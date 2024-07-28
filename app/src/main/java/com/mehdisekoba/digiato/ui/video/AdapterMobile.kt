package com.mehdisekoba.digiato.ui.video

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.mehdisekoba.digiato.R
import com.mehdisekoba.digiato.data.model.video.ResponseMobileVideo
import com.mehdisekoba.digiato.data.model.video.ResponseMobileVideo.ResponseMobileVideoItem
import com.mehdisekoba.digiato.databinding.ItemMobileBinding
import com.mehdisekoba.digiato.utils.base.BaseDiffUtils
import com.mehdisekoba.digiato.utils.extensions.loadImage
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject
import kotlin.random.Random

class AdapterMobile @Inject constructor(@ApplicationContext val context: Context) :
    RecyclerView.Adapter<AdapterMobile.ViewHolder>() {
    private var items = emptyList<ResponseMobileVideoItem>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding =
            ItemMobileBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }


    override fun onBindViewHolder(holder: ViewHolder, position: Int) = holder.bind(items[position])
    override fun getItemCount() = items.size

    inner class ViewHolder(private val binding: ItemMobileBinding) :
        RecyclerView.ViewHolder(binding.root) {
        @SuppressLint("SetTextI18n")
        fun bind(item: ResponseMobileVideoItem) {
            //init view
            binding.apply {
                //image
                itemImage.loadImage(item.image!!)
                //author
                imgAuthor.loadImage(item.authorAvatar!!)
                txtAuthorName.text = "${context.getString(R.string.Written_by)} ${item.author} | ${item.date}"
                //title
                txtTitle.text = item.title
                //description
                txtDescription.text = item.description
                //count
                txtFavCount.text = generateRandomValue().toString()
                txtCommentCount.text = generateRandomValue().toString()
                txtShareCount.text = generateRandomValue().toString()
            }
        }
        private fun generateRandomValue(): Int {
            return Random.nextInt(10, 141)
        }

    }

    fun setData(item: List<ResponseMobileVideoItem>) {
        val adapterDiffUtils = BaseDiffUtils(items, item)
        val diffUtils = DiffUtil.calculateDiff(adapterDiffUtils)
        items = item
        diffUtils.dispatchUpdatesTo(this)
    }
}