package com.example.home_work_lection_8

import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ItemDecoration

class ListItemDecoration (private val space: Int) : ItemDecoration() {
    private val halfSpacing = space / 2

    override fun getItemOffsets(
        outRect: Rect,
        view: View,
        parent: RecyclerView,
        state: RecyclerView.State
    ) {
        super.getItemOffsets(outRect, view, parent, state)
        val columns = (parent.layoutManager as? GridLayoutManager)?.spanCount ?: 1
        val rows = parent.adapter?.itemCount?.div(columns) ?: 1

        val pos = parent.getChildAdapterPosition(view)

        fun setTopSpacing() {
            if (pos / columns + 1 == 1) {
                outRect.top = space
            } else {
                outRect.top = halfSpacing
            }
        }

        fun setBottomSpacing() {
            if (pos / columns + 1 == rows) {
                outRect.bottom = space
            } else {
                outRect.bottom = halfSpacing
            }
        }

        fun setLeftSpacing() {
            if (pos % columns == 0) {
                outRect.left = space
            } else {
                outRect.left = halfSpacing
            }
        }

        fun setRightSpacing() {
            if (pos % columns == columns - 1) {
                outRect.right = space
            } else {
                outRect.right = halfSpacing
            }
        }

        setTopSpacing()
        setBottomSpacing()
        setLeftSpacing()
        setRightSpacing()
    }
}