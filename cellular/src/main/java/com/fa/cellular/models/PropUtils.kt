package com.fa.cellular.models

import android.content.Context
import android.graphics.Typeface
import android.text.TextUtils
import androidx.core.content.ContextCompat
import com.fa.cellular.R
import com.fa.cellular.enums.Color
import com.fa.cellular.enums.Ellipsize
import com.fa.cellular.enums.Gravity
import com.fa.cellular.enums.TextStyle
import androidx.annotation.ColorRes

fun getColor(context: Context, @ColorRes resId: Int): Int = ContextCompat.getColor(context, resId)

val getColorFromPallet: (Context, Int) -> Int = { context: Context, colorCode: Int ->
    getColor(
        context = context, resId = when (colorCode) {
            Color.BLACK.code -> R.color.black
            Color.DK_GRAY.code -> R.color.dk_gray
            Color.LT_GRAY.code -> R.color.lt_gray
            Color.WHITE.code -> R.color.white
            Color.RED.code -> R.color.red
            Color.GREEN.code -> R.color.green
            Color.BLUE.code -> R.color.blue
            Color.YELLOW.code -> R.color.yellow
            Color.PURPLE.code -> R.color.purple
            Color.PINK.code -> R.color.pink
            else -> R.color.black
        }
    )
}

val getEllipsize: (Int) -> TextUtils.TruncateAt? = { headerTextEllipsize: Int ->
    when (headerTextEllipsize) {
        Ellipsize.NONE.code -> null
        Ellipsize.START.code -> TextUtils.TruncateAt.START
        Ellipsize.MIDDLE.code -> TextUtils.TruncateAt.MIDDLE
        Ellipsize.END.code -> TextUtils.TruncateAt.END
        Ellipsize.MARQUEE.code -> TextUtils.TruncateAt.MARQUEE
        else -> null
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
val getTextGravity: (Int) -> Int = { headerTextGravity: Int ->
    when (headerTextGravity) {
        Gravity.START.code -> android.view.Gravity.START
        Gravity.END.code -> android.view.Gravity.END
        Gravity.TOP.code -> android.view.Gravity.TOP
        Gravity.CENTER.code -> android.view.Gravity.CENTER
        Gravity.BOTTOM.code -> android.view.Gravity.BOTTOM
        else -> android.view.Gravity.CENTER
    }
}