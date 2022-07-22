package com.example.nasapictures.util

import android.content.Context
import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ItemDecoration

class PictureDecoration(private var context: Context) : ItemDecoration() {
    override fun getItemOffsets(
        outRect: Rect,
        view: View,
        parent: RecyclerView,
        state: RecyclerView.State
    ) {
        super.getItemOffsets(outRect, view, parent, state)
        val itemPosition = parent.getChildAdapterPosition(view)

        if (itemPosition == 1) {
            outRect.top = context.resources.getDimensionPixelSize(com.intuit.sdp.R.dimen._50sdp)
        }
    }
}
