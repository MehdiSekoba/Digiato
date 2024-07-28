package com.mehdisekoba.digiato.ui.home.adapters

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.mehdisekoba.digiato.R
import com.mehdisekoba.digiato.data.model.home.ResponseSuggestions.ResponseSuggestionsItem
import com.mehdisekoba.digiato.databinding.ItemSuggestionsBinding
import com.mehdisekoba.digiato.utils.base.BaseDiffUtils
import com.mehdisekoba.digiato.utils.extensions.loadImage
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

class AdapterSuggestions @Inject constructor(@ApplicationContext val context: Context) :
    RecyclerView.Adapter<AdapterSuggestions.ViewHolder>() {
    private var items = emptyList<ResponseSuggestionsItem>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding =
            ItemSuggestionsBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }


    override fun onBindViewHolder(holder: ViewHolder, position: Int) = holder.bind(items[position])
    override fun getItemCount() = items.size

    inner class ViewHolder(private val binding: ItemSuggestionsBinding) :
        RecyclerView.ViewHolder(binding.root) {
        @SuppressLint("SetTextI18n")
        fun bind(item: ResponseSuggestionsItem) {
            //init view
            binding.apply {
                //image
                itemImg.loadImage(item.image!!)
                //category
                txtCategory.text = item.category
                //title
                txtTitle.text = item.title
                //author
                txtAuthor.text =
                    "${context.getText(R.string.Written_by)} ${item.author} | ${item.date}"
            }
        }
    }

    fun setData(item: List<ResponseSuggestionsItem>) {
        val adapterDiffUtils = BaseDiffUtils(items, item)
        val diffUtils = DiffUtil.calculateDiff(adapterDiffUtils)
        items = item
        diffUtils.dispatchUpdatesTo(this)
    }
}