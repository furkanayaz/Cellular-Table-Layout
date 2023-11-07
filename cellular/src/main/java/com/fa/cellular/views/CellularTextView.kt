package com.fa.cellular.views

import android.content.Context
import android.util.TypedValue
import android.view.View
import android.widget.TextView
import androidx.core.view.setPadding
import com.fa.cellular.R
import com.fa.cellular.models.ContentProperties
import com.fa.cellular.models.HeaderProperties
import com.fa.cellular.models.getString
import com.fa.cellular.models.getEllipsize
import com.fa.cellular.models.getTextGravity
import com.fa.cellular.models.getTextStyle

fun addHeaderTextView(context: Context, props: HeaderProperties, text: String): TextView =
    TextView(context).also {
        it.id = View.generateViewId()
        it.contentDescription = getString(context = context, resId = R.string.item_text)
        it.setPadding(props.headerPadding.toInt())
        it.maxLines = props.headerTextMaxLines
        it.ellipsize = getEllipsize(props.headerTextEllipsize)
        it.isAllCaps = props.headerIsAllCaps
        it.text = text
        it.gravity = getTextGravity(props.headerTextGravity)
        it.setTextSize(TypedValue.COMPLEX_UNIT_PX, props.headerTextSize)
        it.setTypeface(it.typeface, getTextStyle(props.headerTextStyle.code))
        it.setTextColor(props.headerTextColor)
    }

fun addContentTextView(context: Context, props: ContentProperties, text: String): TextView =
    TextView(context).also {
        it.id = View.generateViewId()
        it.contentDescription = getString(context = context, resId = R.string.item_text)
        it.setPadding(props.contentPadding.toInt())
        it.maxLines = props.contentTextMaxLines
        it.ellipsize = getEllipsize(props.contentTextEllipsize)
        it.isAllCaps = props.contentIsAllCaps
        it.text = text
        it.gravity = getTextGravity(props.contentTextGravity)
        it.setTextSize(TypedValue.COMPLEX_UNIT_PX, props.contentTextSize)
        it.setTypeface(it.typeface, getTextStyle(props.contentTextStyle.code))
        it.setTextColor(props.contentTextColor)
    }