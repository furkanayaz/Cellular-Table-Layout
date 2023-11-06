package com.fa.cellular.views

import android.content.Context
import android.graphics.drawable.Drawable
import androidx.core.content.ContextCompat
import com.fa.cellular.R
import com.fa.cellular.enums.Color
import com.fa.cellular.enums.DividerColor

val getDivColor: (Context, Int) -> Drawable? = { context: Context, divColor: Int ->
    when (divColor) {
        DividerColor.BLACK.code -> ContextCompat.getDrawable(context, R.drawable.divider_black)
        DividerColor.WHITE.code -> ContextCompat.getDrawable(context, R.drawable.divider_white)
        else -> ContextCompat.getDrawable(context, R.drawable.divider_white)
    }
}