package com.mehdisekoba.digiato.utils.other

import android.content.Context
import android.graphics.Canvas
import android.graphics.drawable.Drawable
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.mehdisekoba.digiato.R

class CustomDividerItemDecoration(context: Context) : RecyclerView.ItemDecoration() {
    private val divider: Drawable? = ContextCompat.getDrawable(context, R.drawable.divider)

    override fun onDrawOver(c: Canvas, parent: RecyclerView, state: RecyclerView.State) {
        if (parent.layoutManager == null || divider == null) {
            return
        }

        val orientation =
            (parent.layoutManager as? RecyclerView.LayoutManager)?.canScrollHorizontally()

        if (orientation == true) {
            drawHorizontalDividers(c, parent)
        } else {
            drawVerticalDividers(c, parent)
        }
    }

    private fun drawVerticalDividers(canvas: Canvas, parent: RecyclerView) {
        val left = parent.paddingLeft
        val right = parent.width - parent.paddingRight

        for (i in 0 until parent.childCount - 1) {
            val child = parent.getChildAt(i)
            val params = child.layoutParams as RecyclerView.LayoutParams
            val top = child.bottom + params.bottomMargin
            val bottom = top + divider!!.intrinsicHeight

            divider.setBounds(left, top, right, bottom)
            divider.draw(canvas)
        }
    }

    private fun drawHorizontalDividers(canvas: Canvas, parent: RecyclerView) {
        val left = parent.paddingLeft
        val right = parent.width - parent.paddingRight
        val childCount = parent.childCount
        for (i in 0 until childCount - 1) {
            val child = parent.getChildAt(i)
            val params = child.layoutParams as RecyclerView.LayoutParams
            val top = child.bottom + params.bottomMargin
            val bottom = top + divider!!.intrinsicHeight

            divider.setBounds(left, top, right, bottom)
            divider.draw(canvas)
        }
    }
}
