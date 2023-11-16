package com.fa.cellular.models

import android.content.Context
import android.graphics.Typeface
import android.graphics.drawable.Drawable
import android.text.TextUtils
import android.util.TypedValue
import androidx.core.content.ContextCompat
import com.fa.cellular.enums.Ellipsize
import com.fa.cellular.enums.Gravity
import com.fa.cellular.enums.TextStyle
import androidx.core.content.res.ResourcesCompat
import com.fa.cellular.Cellular
import androidx.annotation.ColorRes
import androidx.annotation.StringRes

internal fun getString(context: Context, @StringRes resId: Int): String =
    ContextCompat.getString(context, resId)

internal fun getColor(context: Context, @ColorRes resId: Int): Int =
    if (Cellular.isFromXml) resId else ResourcesCompat.getColor(context.resources, resId, null)

internal fun getSize(context: Context, size: Int): Float = TypedValue.applyDimension(
    TypedValue.COMPLEX_UNIT_PX, size.toFloat(), context.resources.displayMetrics
)

internal val getDivDrawable: (Context, Int) -> Drawable? = { context: Context, divDrawable: Int ->
    ContextCompat.getDrawable(context, divDrawable)
}

internal val getEllipsize: (Ellipsize) -> TextUtils.TruncateAt? =
    { headerTextEllipsize: Ellipsize ->
        when (headerTextEllipsize) {
            Ellipsize.NONE -> null
            Ellipsize.START -> TextUtils.TruncateAt.START
            Ellipsize.MIDDLE -> TextUtils.TruncateAt.MIDDLE
            Ellipsize.END -> TextUtils.TruncateAt.END
            Ellipsize.MARQUEE -> TextUtils.TruncateAt.MARQUEE
        }
    }

internal val getTextStyle: (Int) -> Int = { headerTextStyle: Int ->
    when (headerTextStyle) {
        TextStyle.NORMAL.code -> Typeface.NORMAL
        TextStyle.BOLD.code -> Typeface.BOLD
        TextStyle.ITALIC.code -> Typeface.ITALIC
        else -> Typeface.NORMAL
    }
}

internal val getTextGravity: (Gravity) -> Int = { headerTextGravity: Gravity ->
    when (headerTextGravity) {
        Gravity.START -> android.view.Gravity.START
        Gravity.END -> android.view.Gravity.END
        Gravity.TOP -> android.view.Gravity.TOP
        Gravity.CENTER -> android.view.Gravity.CENTER
        Gravity.BOTTOM -> android.view.Gravity.BOTTOM
    }
}