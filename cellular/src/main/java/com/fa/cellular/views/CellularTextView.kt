package com.fa.cellular.views

import android.content.Context
import android.view.View
import android.widget.TextView
import androidx.core.view.setPadding
import com.fa.cellular.R
import com.fa.cellular.models.ContentProperties
import com.fa.cellular.models.HeaderProperties
import com.fa.cellular.models.getColor
import com.fa.cellular.models.getString
import com.fa.cellular.models.getSize
import com.fa.cellular.models.getEllipsize
import com.fa.cellular.models.getTextGravity
import com.fa.cellular.models.getTextStyle

fun addHeaderTextView(context: Context, props: HeaderProperties, text: String): TextView =
    TextView(context).also {
        it.id = View.generateViewId()
        it.contentDescription = getString(context = context, resId = R.string.item_text)
        it.setPadding(getSize(context = context, props.headerSpacing).toInt())
        it.maxLines = props.headerTextMaxLines
        it.ellipsize = getEllipsize(props.headerTextEllipsize)
        it.isAllCaps = props.headerIsAllCaps
        it.text = text
        it.gravity = getTextGravity(props.headerTextGravity)
        it.textSize = getSize(context = context, size = props.headerTextSize)
        it.setTypeface(it.typeface, getTextStyle(props.headerTextStyle.code))
        it.setTextColor(getColor(context = context, resId = props.headerTextColor))
    }

fun addContentTextView(context: Context, props: ContentProperties, text: String): TextView =
    TextView(context).also {
        it.id = View.generateViewId()
        it.contentDescription = getString(context = context, resId = R.string.item_text)
        it.setPadding(getSize(context = context, props.contentSpacing).toInt())
        it.maxLines = props.contentTextMaxLines
        it.ellipsize = getEllipsize(props.contentTextEllipsize)
        it.isAllCaps = props.contentIsAllCaps
        it.text = text
        it.gravity = getTextGravity(props.contentTextGravity)
        it.textSize = getSize(context = context, size = props.contentTextSize)
        it.setTypeface(it.typeface, getTextStyle(props.contentTextStyle.code))
        it.setTextColor(getColor(context = context, resId = props.contentTextColor))
    }