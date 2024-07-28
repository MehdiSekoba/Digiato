package com.mehdisekoba.digiato.ui

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatDelegate
import androidx.core.view.isVisible
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.mehdisekoba.digiato.R
import com.mehdisekoba.digiato.data.stored.ThemeManager
import com.mehdisekoba.digiato.databinding.ActivityMainBinding
import com.mehdisekoba.digiato.utils.base.BaseActivity
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
@Suppress("DEPRECATION")
class MainActivity : BaseActivity() {
    //binding
    private var _binding: ActivityMainBinding? = null
    private val binding get() = _binding!!

    @Inject
    lateinit var themeManager: ThemeManager

    //other
    private lateinit var navHost: NavHostFragment
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        //init
        navHost = supportFragmentManager.findFragmentById(R.id.navHost) as NavHostFragment
        // Bottom nav menu
        binding.bottomNav.apply {
            setupWithNavController(navHost.navController)
            // Disable double click on items
            setOnNavigationItemReselectedListener {}
        }
        // Gone bottom menu
        navHost.navController.addOnDestinationChangedListener { _, destination, _ ->
            binding.apply {
                when (destination.id) {
                    R.id.splashFragment -> bottomNav.isVisible = false
                    else -> bottomNav.isVisible = true
                }
            }
        }
        lifecycleScope.launch {
            themeManager.isDarkTheme.collect { isDarkTheme ->
                if (isDarkTheme){
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
                }else{
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
                }
            }
        }

    }


    override fun onNavigateUp(): Boolean =
        navHost.navController.navigateUp() || super.onNavigateUp()

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}