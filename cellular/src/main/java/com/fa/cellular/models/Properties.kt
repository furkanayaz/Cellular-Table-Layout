package com.fa.cellular.models

import com.fa.cellular.enums.DividerColor

data class Properties(
    val enableDivider: Boolean = true,
    val dividerColor: Int = DividerColor.WHITE.code,
    val headerProperties: HeaderProperties = HeaderProperties(),
    val contentProperties: ContentProperties = ContentProperties()
)