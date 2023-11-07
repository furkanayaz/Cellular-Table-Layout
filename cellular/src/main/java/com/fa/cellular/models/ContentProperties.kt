package com.fa.cellular.models

import android.graphics.Color
import androidx.annotation.ColorInt
import com.fa.cellular.enums.Ellipsize
import com.fa.cellular.enums.Gravity
import com.fa.cellular.enums.TextStyle

data class ContentProperties(
    private var contentItems: MutableList<String> = mutableListOf(),
    @ColorInt val contentBgColor: Int = Color.LTGRAY,
    val contentPadding: Float = 5.0F,
    val contentTextSize: Float = 14.0F,
    @ColorInt val contentTextColor: Int = Color.BLACK,
    val contentTextMaxLines: Int = 1,
    val contentTextEllipsize: Ellipsize = Ellipsize.NONE,
    val contentTextStyle: TextStyle = TextStyle.NORMAL,
    val contentTextGravity: Gravity = Gravity.CENTER,
    val contentIsAllCaps: Boolean = true,
) {
    fun setContentItems(items: List<String>) {
        contentItems.clear()
        contentItems.addAll(items)
    }

    fun getContentItems(): MutableList<String> = contentItems
}