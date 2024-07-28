package com.mehdisekoba.digiato.ui.categories

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.mehdisekoba.digiato.R
import com.mehdisekoba.digiato.data.model.category.ResponseCategory
import com.mehdisekoba.digiato.databinding.FragmentCategoriesBinding
import com.mehdisekoba.digiato.utils.base.BaseFragment
import com.mehdisekoba.digiato.utils.extensions.showSnackBar
import com.mehdisekoba.digiato.utils.network.NetworkRequest
import com.mehdisekoba.digiato.viewmodel.CategoryViewModel
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject


@AndroidEntryPoint
class CategoriesFragment : BaseFragment<FragmentCategoriesBinding>() {
    override val bindingInflater: (inflater: LayoutInflater) -> FragmentCategoriesBinding
        get() = FragmentCategoriesBinding::inflate

    @Inject
    lateinit var adapter: AdapterCategories

    //other
    private val viewModel by viewModels<CategoryViewModel>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //init view
        binding.apply {
            if (isNetworkAvailable) {
                loadCategoriesData()
            } else {
                //show error
                internetLay.visibility = View.VISIBLE
            }
        }
    }

    private fun loadCategoriesData() {
        binding.apply {
            viewModel.categoryData.observe(viewLifecycleOwner) { response ->
                when (response) {
                    is NetworkRequest.Loading -> {
                        veilLayoutToolbar.veil()
                        listCategories.veil()
                    }

                    is NetworkRequest.Success -> {
                        veilLayoutToolbar.unVeil()
                        listCategories.unVeil()
                        response.data?.let { data ->
                            initRecyclerView(data)
                        }
                    }

                    is NetworkRequest.Error -> {
                        veilLayoutToolbar.unVeil()
                        listCategories.unVeil()
                    }
                }
            }
        }
    }

    private fun initRecyclerView(data: ResponseCategory) {
        adapter.setData(data)
        binding.listCategories.apply {
            setAdapter(adapter)
            setVeilLayout(R.layout.item_categories, false)
            setLayoutManager(GridLayoutManager(requireContext(), 2))
            addVeiledItems(10)
        }
    }

}