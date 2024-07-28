package com.mehdisekoba.digiato.ui.categories

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.mehdisekoba.digiato.data.model.category.ResponseCategory.ResponseCategoryItem
import com.mehdisekoba.digiato.databinding.ItemCategoriesBinding
import com.mehdisekoba.digiato.utils.base.BaseDiffUtils
import com.mehdisekoba.digiato.utils.extensions.loadImage
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

class AdapterCategories @Inject constructor(@ApplicationContext val context: Context) :
    RecyclerView.Adapter<AdapterCategories.ViewHolder>() {
    private var items = emptyList<ResponseCategoryItem>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding =
            ItemCategoriesBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }


    override fun onBindViewHolder(holder: ViewHolder, position: Int) = holder.bind(items[position])
    override fun getItemCount() = items.size

    inner class ViewHolder(private val binding: ItemCategoriesBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: ResponseCategoryItem) {
            //init view
            binding.apply {
                //image
                itemImage.loadImage(item.image!!)
                //title
                txtTitle.text = item.title
            }
        }
    }

    fun setData(item: List<ResponseCategoryItem>) {
        val adapterDiffUtils = BaseDiffUtils(items, item)
        val diffUtils = DiffUtil.calculateDiff(adapterDiffUtils)
        items = item
        diffUtils.dispatchUpdatesTo(this)
    }
}