package com.fa.cellular.models

import com.fa.cellular.enums.Ellipsize
import com.fa.cellular.enums.Gravity
import com.fa.cellular.enums.TextStyle
import com.fa.cellular.R
import androidx.annotation.ColorRes

data class HeaderProperties(
    private var headerItems: MutableList<String> = mutableListOf(),
    @ColorRes val headerBgColor: Int = R.color.dk_gray,
    val headerSpacing: Int = 5,
    val headerTextSize: Int = 14,
    @ColorRes val headerTextColor: Int = R.color.white,
    val headerTextMaxLines: Int = 1,
    val headerTextEllipsize: Ellipsize = Ellipsize.NONE,
    val headerTextStyle: TextStyle = TextStyle.NORMAL,
    val headerTextGravity: Gravity = Gravity.CENTER,
    val headerIsAllCaps: Boolean = true,
) {
    fun setHeaderItems(items: List<String>) {
        headerItems.clear()
        headerItems.addAll(items)
    }

    fun getHeaderItems(): MutableList<String> = headerItems
}