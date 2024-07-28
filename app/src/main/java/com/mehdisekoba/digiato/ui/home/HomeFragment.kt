package com.mehdisekoba.digiato.ui.home

import android.os.Bundle
import android.util.TypedValue
import android.view.LayoutInflater
import android.view.View
import android.view.animation.AnimationUtils
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.fondesa.recyclerviewdivider.dividerBuilder
import com.mehdisekoba.digiato.R
import com.mehdisekoba.digiato.data.model.home.ResponseSuggestions
import com.mehdisekoba.digiato.data.model.home.ResponseToday
import com.mehdisekoba.digiato.data.model.home.ResponseTodayHot
import com.mehdisekoba.digiato.databinding.FragmentHomeBinding
import com.mehdisekoba.digiato.ui.home.adapters.AdapterHotToday
import com.mehdisekoba.digiato.ui.home.adapters.AdapterSuggestions
import com.mehdisekoba.digiato.ui.home.adapters.AdapterToday
import com.mehdisekoba.digiato.utils.base.BaseFragment
import com.mehdisekoba.digiato.utils.extensions.convertToDateNameFa
import com.mehdisekoba.digiato.utils.extensions.loadImage
import com.mehdisekoba.digiato.utils.extensions.onceObserve
import com.mehdisekoba.digiato.utils.network.NetworkRequest
import com.mehdisekoba.digiato.utils.other.CustomDividerItemDecoration
import com.mehdisekoba.digiato.viewmodel.HomeViewModel
import dagger.hilt.android.AndroidEntryPoint
import org.threeten.bp.LocalDate
import javax.inject.Inject

@AndroidEntryPoint
class HomeFragment : BaseFragment<FragmentHomeBinding>() {
    override val bindingInflater: (inflater: LayoutInflater) -> FragmentHomeBinding
        get() = FragmentHomeBinding::inflate


    @Inject
    lateinit var hotToday: AdapterHotToday

    @Inject
    lateinit var suggest: AdapterSuggestions

    @Inject
    lateinit var today: AdapterToday


    //other
    private val viewModel by viewModels<HomeViewModel>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        // check connection
        //call data
        callTodayHotData()
        callSuggestionData()
        callTodayNewsData()
    }

    //call today hot data
    private fun callTodayHotData() {
        viewModel.readTodayHotDb.onceObserve(viewLifecycleOwner) { database ->
            if (!isNetworkAvailable) {
                if (database.isNotEmpty()) {
                    initTodayHotRecyclerView(database[0].result)
                }
            } else {
                viewModel.callTodayHotApi()
                loadTodayHotNews()

            }

        }
    }

    private fun loadTodayHotNews() {
        binding.apply {
            viewModel.todayHotData.observe(viewLifecycleOwner) { response ->
                when (response) {
                    is NetworkRequest.Loading -> {
                        veilLayoutContent.veil()
                        todayHotList.veil()
                    }

                    is NetworkRequest.Success -> {
                        veilLayoutContent.unVeil()
                        todayHotList.unVeil()
                        response.data?.let { data ->
                            initTodayHotRecyclerView(data)
                        }
                    }

                    is NetworkRequest.Error -> {
                        veilLayoutContent.veil()
                        todayHotList.veil()

                    }
                }
            }
        }
    }

    private fun initTodayHotRecyclerView(data: ResponseTodayHot) {
        binding.apply {
            hotToday.setData(data)
            todayHotList.apply {
                unVeil()
                setAdapter(hotToday)
                setLayoutManager(
                    LinearLayoutManager(
                        requireContext(),
                        LinearLayoutManager.HORIZONTAL,
                        true
                    )
                )

                context.dividerBuilder()
                    .drawableRes(R.drawable.divider)
                    .size(1, TypedValue.COMPLEX_UNIT_DIP)
                    .build()
                    .addTo(todayHotList.getRecyclerView())
                addVeiledItems(10)
            }

        }

    }

    // call suggestion data
    private fun callSuggestionData() {
        viewModel.readSuggestionsDb.onceObserve(viewLifecycleOwner) { database ->
            if (!isNetworkAvailable) {
                if (database.isNotEmpty()) {
                    initSuggestRecyclerView(database[0].result)
                }
            } else {
                viewModel.callSuggestApi()
                loadSuggestionsDataApi()

            }


        }
    }

    private fun loadSuggestionsDataApi() {
        binding.apply {
            viewModel.suggestData.observe(viewLifecycleOwner) { response ->
                when (response) {
                    is NetworkRequest.Loading -> {
                        veilLayoutToolbar.veil()
                        veilLayoutContent.veil()
                        suggestionList.veil()

                    }

                    is NetworkRequest.Success -> {
                        veilLayoutToolbar.unVeil()
                        veilLayoutContent.unVeil()
                        suggestionList.unVeil()
                        val today: LocalDate = LocalDate.now()
                        txtDate.text = today.toString().convertToDateNameFa()
                        BadgeImg.animation =
                            AnimationUtils.loadAnimation(requireContext(), R.anim.flash_leave_now)
                        response.data?.let { data ->
                            initSuggestRecyclerView(data)
                        }
                    }

                    is NetworkRequest.Error -> {
                        veilLayoutToolbar.unVeil()
                        veilLayoutContent.unVeil()
                        suggestionList.unVeil()

                    }
                }
            }
        }
    }

    private fun initSuggestRecyclerView(data: ResponseSuggestions) {
        binding.apply {
            suggest.setData(data)
            suggestionList.apply {
                setVeilLayout(layout = R.layout.item_suggestions, isPrepared = true)
                setAdapter(suggest)
                setLayoutManager(
                    LinearLayoutManager(
                        requireContext(),
                        LinearLayoutManager.HORIZONTAL,
                        true
                    )
                )
                addVeiledItems(10)
            }
        }
    }

    //call today data
    private fun callTodayNewsData() {
        viewModel.readTodayDb.onceObserve(viewLifecycleOwner) { database ->
            if (!isNetworkAvailable) {
                if (database.isNotEmpty()) {
                    initTodayRecyclerView(database[0].result)
                }
            } else {
                viewModel.callTodayNewsApi()
                loadTodayDataApi()

            }


        }
    }

    private fun loadTodayDataApi() {
        binding.apply {
            viewModel.todayNewsData.observe(viewLifecycleOwner) { response ->
                when (response) {
                    is NetworkRequest.Loading -> {
                        veilLayoutContent.veil()
                        todayList.veil()
                    }

                    is NetworkRequest.Success -> {
                        veilLayoutContent.unVeil()
                        todayList.unVeil()
                        response.data?.let { data ->
                            imgTrend.loadImage(data[0].image!!)
                            trendTxt.text = data[0].category
                            titleTrend.text = data[0].title
                            initTodayRecyclerView(data)
                        }
                    }

                    is NetworkRequest.Error -> {
                        veilLayoutContent.unVeil()
                        todayList.unVeil()

                    }
                }
            }
        }

    }

    private fun initTodayRecyclerView(data: ResponseToday) {

        binding.apply {
            veilLayoutToolbar.unVeil()
            data[0].image?.let { imgTrend.loadImage(it) }
            trendTxt.text = data[0].category
            titleTrend.text = data[0].title

            todayList.apply {
                today.setData(data)
                addVeiledItems(10)
                getRecyclerView().addItemDecoration(CustomDividerItemDecoration(requireContext()))
                setLayoutManager(LinearLayoutManager(requireContext()))
                setAdapter(today)
            }
        }
    }


}