package com.fa.cellular.models

import android.content.Context
import android.graphics.Typeface
import android.graphics.drawable.Drawable
import android.text.TextUtils
import androidx.core.content.ContextCompat
import com.fa.cellular.enums.Ellipsize
import com.fa.cellular.enums.Gravity
import com.fa.cellular.enums.TextStyle
import androidx.annotation.StringRes
import androidx.core.content.res.ResourcesCompat

fun getString(context: Context, @StringRes resId: Int): String =
    ContextCompat.getString(context, resId)

fun getColor(context: Context, resId: Int): Int = ResourcesCompat.getColor(context.resources, resId, null)

val getDivDrawable: (Context, Int) -> Drawable? = { context: Context, divDrawable: Int ->
    ContextCompat.getDrawable(context, divDrawable)
}

val getEllipsize: (Ellipsize) -> TextUtils.TruncateAt? = { headerTextEllipsize: Ellipsize ->
    when (headerTextEllipsize) {
        Ellipsize.NONE -> null
        Ellipsize.START -> TextUtils.TruncateAt.START
        Ellipsize.MIDDLE -> TextUtils.TruncateAt.MIDDLE
        Ellipsize.END -> TextUtils.TruncateAt.END
        Ellipsize.MARQUEE -> TextUtils.TruncateAt.MARQUEE
    }
}
val getTextStyle: (Int) -> Int = { headerTextStyle: Int ->
    when (headerTextStyle) {
        TextStyle.NORMAL.code -> Typeface.NORMAL
        TextStyle.BOLD.code -> Typeface.BOLD
        TextStyle.ITALIC.code -> Typeface.ITALIC
        else -> Typeface.NORMAL
    }
}
val getTextGravity: (Gravity) -> Int = { headerTextGravity: Gravity ->
    when (headerTextGravity) {
        Gravity.START -> android.view.Gravity.START
        Gravity.END -> android.view.Gravity.END
        Gravity.TOP -> android.view.Gravity.TOP
        Gravity.CENTER -> android.view.Gravity.CENTER
        Gravity.BOTTOM -> android.view.Gravity.BOTTOM
    }
}