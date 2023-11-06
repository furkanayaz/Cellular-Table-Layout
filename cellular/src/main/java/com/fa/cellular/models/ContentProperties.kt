package com.fa.cellular.models

import com.fa.cellular.enums.Color
import com.fa.cellular.enums.Ellipsize
import com.fa.cellular.enums.Gravity
import com.fa.cellular.enums.TextStyle

data class ContentProperties(
    private var contentItems: List<String> = listOf(),
    val contentBgColor: Int = Color.LT_GRAY.code,
    val contentPadding: Float = 5.0F,
    val contentTextSize: Int = 14,
    val contentTextColor: Int = Color.BLACK.code,
    val contentTextMaxLines: Int = 1,
    val contentTextEllipsize: Int = Ellipsize.NONE.code,
    val contentTextStyle: Int = TextStyle.NORMAL.code,
    val contentTextGravity: Int = Gravity.CENTER.code,
    val contentIsAllCaps: Boolean = true,
) {
    fun setContentItems(items: List<String>) {
        contentItems = items
    }

    fun getContentItems(): List<String> = contentItems
}