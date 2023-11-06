package com.fa.cellular.models

import com.fa.cellular.enums.Color
import com.fa.cellular.enums.Ellipsize
import com.fa.cellular.enums.Gravity
import com.fa.cellular.enums.TextStyle

data class HeaderProperties(
    private var headerItems: List<String> = listOf(),
    val headerBgColor: Int = Color.DK_GRAY.code,
    val headerPadding: Float = 5.0F,
    val headerTextSize: Int = 14,
    val headerTextColor: Int = Color.WHITE.code,
    val headerTextMaxLines: Int = 1,
    val headerTextEllipsize: Int = Ellipsize.NONE.code,
    val headerTextStyle: Int = TextStyle.NORMAL.code,
    val headerTextGravity: Int = Gravity.CENTER.code,
    val headerIsAllCaps: Boolean = true,
) {
    fun setHeaderItems(items: List<String>) {
        headerItems = items
    }

    fun getHeaderItems(): List<String> = headerItems
}