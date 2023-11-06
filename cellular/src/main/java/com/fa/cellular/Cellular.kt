package com.fa.cellular

import android.content.Context
import android.content.res.TypedArray
import android.util.AttributeSet
import android.widget.HorizontalScrollView
import com.fa.cellular.enums.Gravity
import com.fa.cellular.enums.Ellipsize
import com.fa.cellular.models.ContentProperties
import com.fa.cellular.enums.TextStyle
import com.fa.cellular.views.addTableLayout
import com.fa.cellular.models.HeaderProperties
import com.fa.cellular.models.Properties
import com.fa.cellular.enums.Color
import com.fa.cellular.exceptions.DataNotSet
import com.fa.cellular.models.getColor

class Cellular : HorizontalScrollView {
    private lateinit var typedArray: TypedArray
    private lateinit var properties: Properties
    private lateinit var headerProperties: HeaderProperties
    private lateinit var contentProperties: ContentProperties
    private var columnCount: Int? = null

    constructor(context: Context) : super(context)

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {
        if ((::typedArray.isInitialized && ::headerProperties.isInitialized && ::contentProperties.isInitialized).not()) {
            this.apply {
                isHorizontalScrollBarEnabled = true
                isVerticalScrollBarEnabled = true
            }

            typedArray = context.obtainStyledAttributes(attrs, R.styleable.Cellular)

            getHeaderProperties()
            getContentProperties()
            getProperties()

            typedArray.recycle()
        }
    }

    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int = 0) : super(
        context,
        attrs,
        defStyleAttr
    )

    inner class Builder(private var properties: Properties) {
        private lateinit var cellular: Cellular

        fun setItems(
            headerItems: List<String>,
            contentItems: List<String>
        ) {
            cellular = Cellular(context).also {
                it.columnCount = headerItems.size
                it.properties = properties.copy(
                    enableDivider = properties.enableDivider,
                    dividerColor = properties.dividerColor,
                    headerProperties = properties.headerProperties,
                    contentProperties = properties.contentProperties
                )
                it.headerProperties =
                    properties.headerProperties.also { props: HeaderProperties ->
                        props.setHeaderItems(items = headerItems)
                    }
                it.contentProperties =
                    properties.contentProperties.also { props: ContentProperties ->
                        props.setContentItems(items = contentItems)
                    }
            }
        }

        @Throws
        fun build(): Cellular {
            if (::cellular.isInitialized.not()) {
                throw DataNotSet()
            }

            return cellular.apply instance@{
                this@instance.apply {
                    this.isHorizontalScrollBarEnabled = true
                    this.isVerticalScrollBarEnabled = true
                }

                this@instance.columnCount?.let count@{ count: Int ->
                    this@instance.addView(
                        addTableLayout(
                            context = context,
                            props = properties,
                            columnCount = count
                        )
                    )
                }
            }
        }
    }

    private fun getHeaderProperties() {
        headerProperties = HeaderProperties(
            headerBgColor = typedArray.getInt(
                R.styleable.Cellular_headerBgColor,
                getColor(context = context, resId = R.color.header_color)
            ),
            headerPadding = typedArray.getDimension(
                R.styleable.Cellular_headerPadding,
                5.0F
            ),
            headerTextSize = typedArray.getDimensionPixelSize(
                R.styleable.Cellular_headerTextSize,
                14
            ),
            headerTextColor = typedArray.getInt(
                R.styleable.Cellular_headerTextColor,
                getColor(context = context, resId = R.color.text_color)
            ),
            headerTextMaxLines = typedArray.getInt(
                R.styleable.Cellular_headerTextMaxLines,
                1
            ),
            headerTextEllipsize = typedArray.getInt(
                R.styleable.Cellular_headerTextEllipsize,
                Ellipsize.NONE.code
            ),
            headerTextStyle = typedArray.getInt(
                R.styleable.Cellular_headerTextStyle,
                TextStyle.NORMAL.code
            ),
            headerTextGravity = typedArray.getInt(
                R.styleable.Cellular_headerTextGravity,
                Gravity.CENTER.code
            ),
            headerIsAllCaps = typedArray.getBoolean(
                R.styleable.Cellular_headerTextAllCaps,
                false
            )
        )
    }

    private fun getContentProperties() {
        contentProperties = ContentProperties(
            contentBgColor = typedArray.getInt(
                R.styleable.Cellular_contentBgColor,
                getColor(context = context, resId = R.color.content_color)
            ),
            contentPadding = typedArray.getDimension(
                R.styleable.Cellular_contentPadding,
                5.0F
            ),
            contentTextSize = typedArray.getDimensionPixelSize(
                R.styleable.Cellular_contentTextSize,
                14
            ),
            contentTextColor = typedArray.getInt(
                R.styleable.Cellular_contentTextColor,
                getColor(context = context, resId = R.color.text_color)
            ),
            contentTextMaxLines = typedArray.getInt(
                R.styleable.Cellular_contentTextMaxLines,
                1
            ),
            contentTextEllipsize = typedArray.getInt(
                R.styleable.Cellular_contentTextEllipsize,
                Ellipsize.NONE.code
            ),
            contentTextStyle = typedArray.getInt(
                R.styleable.Cellular_contentTextStyle,
                TextStyle.NORMAL.code
            ),
            contentTextGravity = typedArray.getInt(
                R.styleable.Cellular_contentTextGravity,
                Gravity.CENTER.code
            ),
            contentIsAllCaps = typedArray.getBoolean(
                R.styleable.Cellular_contentTextAllCaps,
                false
            )
        )
    }

    private fun getProperties() {
        properties = Properties(
            enableDivider = typedArray.getBoolean(R.styleable.Cellular_enableDivider, true),
            dividerColor = typedArray.getInt(R.styleable.Cellular_divColor, Color.WHITE.code),
            headerProperties = headerProperties,
            contentProperties = contentProperties
        )
    }
}