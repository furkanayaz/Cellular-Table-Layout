package com.fa.cellular.models

import android.graphics.Color
import androidx.annotation.ColorInt
import com.fa.cellular.enums.Ellipsize
import com.fa.cellular.enums.Gravity
import com.fa.cellular.enums.TextStyle

data class HeaderProperties(
    private var headerItems: MutableList<String> = mutableListOf(),
    @ColorInt val headerBgColor: Int = Color.DKGRAY,
    val headerPadding: Float = 5.0F,
    val headerTextSize: Float = 14.0F,
    @ColorInt val headerTextColor: Int = Color.WHITE,
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