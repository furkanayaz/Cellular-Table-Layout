package com.fa.cellular.models

import com.fa.cellular.R
import androidx.annotation.DrawableRes

data class TableProperties(
    val enableDivider: Boolean = true,
    @DrawableRes val divResId: Int = R.drawable.divider_white
)
