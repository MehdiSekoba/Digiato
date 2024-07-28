package com.mehdisekoba.digiato.ui.video

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.mehdisekoba.digiato.R
import com.mehdisekoba.digiato.data.model.video.ResponseMobileVideo
import com.mehdisekoba.digiato.databinding.FragmentVideoBinding
import com.mehdisekoba.digiato.utils.base.BaseFragment
import com.mehdisekoba.digiato.utils.extensions.onceObserve
import com.mehdisekoba.digiato.utils.extensions.showSnackBar
import com.mehdisekoba.digiato.utils.network.NetworkRequest
import com.mehdisekoba.digiato.viewmodel.MobileViewModel
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class VideoFragment : BaseFragment<FragmentVideoBinding>() {
    override val bindingInflater: (inflater: LayoutInflater) -> FragmentVideoBinding
        get() = FragmentVideoBinding::inflate

    @Inject
    lateinit var adapterMobile: AdapterMobile

    //other
    private val viewModel by viewModels<MobileViewModel>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //init
        callTodayHotData()
    }

    private fun callTodayHotData() {
        viewModel.readMobileDb.onceObserve(viewLifecycleOwner) { database ->
            if (!isNetworkAvailable) {
                if (database.isNotEmpty()) {
                    initRecyclerView(database[0].result)
                }
            } else {
                viewModel.callMobileApi()
                loadMobileData()

            }

        }
    }

    private fun loadMobileData() {
        binding.apply {
            viewModel.mobileData.observe(viewLifecycleOwner) { response ->
                when (response) {
                    is NetworkRequest.Loading -> {
                        veilLayoutToolbar.veil()
                        listMobile.veil()
                        loading.isVisible = true

                    }

                    is NetworkRequest.Success -> {
                        veilLayoutToolbar.unVeil()
                        listMobile.unVeil()
                        loading.isVisible = false


                        response.data?.let { data ->
                            initRecyclerView(data)
                        }
                    }

                    is NetworkRequest.Error -> {
                        veilLayoutToolbar.unVeil()
                        listMobile.veil()
                        loading.isVisible = false

                    }
                }
            }
        }
    }

    private fun initRecyclerView(data: ResponseMobileVideo) {
        adapterMobile.setData(data)
        binding.listMobile.apply {
            setAdapter(adapterMobile)
            setVeilLayout(R.layout.item_mobile, false)
            setLayoutManager(LinearLayoutManager(requireContext()))
            addVeiledItems(10)
        }
    }
}