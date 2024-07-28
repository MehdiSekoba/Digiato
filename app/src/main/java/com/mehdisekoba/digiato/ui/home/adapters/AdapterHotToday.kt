package com.mehdisekoba.digiato.ui.home.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.mehdisekoba.digiato.data.model.home.ResponseTodayHot.ResponseTodayHotItem
import com.mehdisekoba.digiato.databinding.ItemHotBinding
import com.mehdisekoba.digiato.utils.base.BaseDiffUtils
import com.mehdisekoba.digiato.utils.extensions.loadImage
import javax.inject.Inject

class AdapterHotToday @Inject constructor() :
    RecyclerView.Adapter<AdapterHotToday.ViewHolder>() {
    private var items = emptyList<ResponseTodayHotItem>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding =
            ItemHotBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }


    override fun onBindViewHolder(holder: ViewHolder, position: Int) = holder.bind(items[position])
    override fun getItemCount() = items.size

    inner class ViewHolder(private val binding: ItemHotBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: ResponseTodayHotItem) {
            //init view
            binding.apply {
                //title
                txtTitle.text = item.title
                //image
                itemImg.loadImage(item.image!!)
                //date
                txtDate.text = item.date
            }
        }
    }

    fun setData(item: List<ResponseTodayHotItem>) {
        val adapterDiffUtils = BaseDiffUtils(items, item)
        val diffUtils = DiffUtil.calculateDiff(adapterDiffUtils)
        items = item
        diffUtils.dispatchUpdatesTo(this)
    }
}