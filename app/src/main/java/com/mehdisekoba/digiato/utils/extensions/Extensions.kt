package com.mehdisekoba.digiato.utils.extensions

import android.widget.ImageView
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import coil.load
import coil.request.CachePolicy
import com.mehdisekoba.digiato.R
import com.mehdisekoba.digiato.utils.other.TimeUtils


fun ImageView.loadImage(url: String) {
    this.load(url) {
        crossfade(true)
        crossfade(500)
        diskCachePolicy(CachePolicy.ENABLED)
        error(R.drawable.placeholder)
    }
}

fun String.convertToDateNameFa(): String {
    val dateSplit = this.split("-")
    val year = dateSplit[0].toInt()
    val month = dateSplit[1].toInt()
    val day = dateSplit[2].toInt()
    val timeUtils = TimeUtils(year, month, day)
    val iranianMonth = timeUtils.iranianMonthName
    val iranianDay = timeUtils.iranianDay
    return "$iranianDay _ $iranianMonth"
}

fun <T> LiveData<T>.onceObserve(owner: LifecycleOwner, observe: Observer<T>) {
    observe(owner, object : Observer<T> {
        override fun onChanged(value: T) {
            removeObserver(this)
            observe.onChanged(value)
        }
    })
}
