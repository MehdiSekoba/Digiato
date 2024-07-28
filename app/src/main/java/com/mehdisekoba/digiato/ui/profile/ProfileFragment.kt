package com.mehdisekoba.digiato.ui.profile

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatDelegate
import androidx.lifecycle.lifecycleScope
import com.mehdisekoba.digiato.R
import com.mehdisekoba.digiato.data.stored.ThemeManager
import com.mehdisekoba.digiato.databinding.FragmentProfileBinding
import com.mehdisekoba.digiato.utils.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
class ProfileFragment : BaseFragment<FragmentProfileBinding>() {
    override val bindingInflater: (LayoutInflater) -> FragmentProfileBinding = FragmentProfileBinding::inflate

    @Inject
    lateinit var themeManager: ThemeManager

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Observe theme preference
        viewLifecycleOwner.lifecycleScope.launch {
            themeManager.isDarkTheme.collect { isDarkTheme ->
                if (binding.orderLay.switchTheme.isChecked != isDarkTheme) {
                    binding.orderLay.switchTheme.isChecked = isDarkTheme
                }
                if (isDarkTheme){
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
                }else{
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
                }
            }
        }

        binding.orderLay.switchTheme.setOnCheckedChangeListener { _, isChecked ->
            viewLifecycleOwner.lifecycleScope.launch {
                themeManager.saveTheme(isChecked)
            }
        }
    }
}
