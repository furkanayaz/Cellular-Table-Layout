package com.fa.cellular.models

import com.fa.cellular.enums.Ellipsize
import com.fa.cellular.enums.Gravity
import com.fa.cellular.enums.TextStyle
import com.fa.cellular.R
import androidx.annotation.ColorRes

data class ContentProperties(
    private var contentItems: MutableList<String> = mutableListOf(),
    @ColorRes val contentBgColor: Int = R.color.content_bg,
    @ColorRes val contentBgEffectColor: Int = R.color.content_effect_bg,
    val contentSpacing: Int = 5,
    val contentTextSize: Int = 14,
    @ColorRes val contentTextColor: Int = R.color.black,
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