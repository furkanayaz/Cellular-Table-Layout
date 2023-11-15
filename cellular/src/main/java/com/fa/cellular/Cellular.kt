package com.fa.cellular

import android.content.Context
import android.content.res.TypedArray
import android.util.AttributeSet
import android.widget.HorizontalScrollView
import android.widget.TableLayout
import androidx.core.view.children
import com.fa.cellular.enums.Gravity
import com.fa.cellular.enums.Ellipsize
import com.fa.cellular.enums.Section
import com.fa.cellular.models.ContentProperties
import com.fa.cellular.enums.TextStyle
import com.fa.cellular.views.addTableLayout
import com.fa.cellular.models.HeaderProperties
import com.fa.cellular.models.Properties
import com.fa.cellular.exceptions.DataNotSetException
import com.fa.cellular.exceptions.ItemSizeException
import com.fa.cellular.models.TableProperties
import com.fa.cellular.models.getString
import com.fa.cellular.views.addTableRow
import android.util.DisplayMetrics
import android.widget.ScrollView
import android.widget.TableRow
import com.fa.cellular.models.getColor

class Cellular : ScrollView {
    private lateinit var typedArray: TypedArray
    private lateinit var metrics: DisplayMetrics
    private lateinit var cellularObj: Cellular
    private val properties: Properties by lazy { Properties() }
    private var columnCount: Int? = null

    companion object {
        var isFromXml: Boolean = false
    }

    constructor(context: Context, properties: Properties = Properties()) : super(context) {
        isFromXml = false
        metrics = resources.displayMetrics
        cellularObj = this

        cellularObj.properties.apply props@{
            this@props.tableProperties = properties.tableProperties
            this@props.headerProperties = properties.headerProperties
            this@props.contentProperties = properties.contentProperties
        }
    }

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {
        if ((::typedArray.isInitialized).not()) {
            this.apply {
                isFromXml = true
                metrics = resources.displayMetrics
                cellularObj = this
                contentDescription = getString(context = context, resId = R.string.items_scroll)
            }

            getTypedArray(attrs = attrs)
            getTableProperties()
            getHeaderProperties()
            getContentProperties()

            typedArray.recycle()
        }
    }

    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int = 0) : super(
        context,
        attrs,
        defStyleAttr
    )

    fun setItems(
        headerItems: List<String>,
        contentItems: List<String>
    ) {
        cellularObj.also { cellular: Cellular ->
            cellular.columnCount = headerItems.size
            cellular.properties.also { props: Properties ->
                props.tableProperties = properties.tableProperties
                props.headerProperties =
                    properties.headerProperties.also { headerProps: HeaderProperties ->
                        headerProps.setHeaderItems(items = headerItems)
                    }
                props.contentProperties =
                    properties.contentProperties.also { contentProps: ContentProperties ->
                        contentProps.setContentItems(items = contentItems)
                    }
            }
        }
    }

    @Throws
    fun setContentItem(item: List<String>) {
        if (item.size != properties.headerProperties.getHeaderItems().size) {
            throw ItemSizeException()
        }

        val rootView: TableLayout =
            (cellularObj.children.first() as HorizontalScrollView).children.first() as TableLayout
        properties.contentProperties.getContentItems().addAll(item)
        rootView.addView(
            addTableRow(
                context = context,
                props = properties,
                sectionType = Section.CONTENT,
                rootView = rootView,
                singleItem = item,
                isMultiItem = false
            ).also { row: TableRow ->
                val controller: Int =
                    properties.contentProperties.getContentItems().size / properties.headerProperties.getHeaderItems().size
                row.setBackgroundColor(
                    getColor(
                        context = context,
                        resId = if ((controller % 2) == 0) properties.contentProperties.contentBgColor else properties.contentProperties.contentBgEffectColor
                    )
                )
            }
        )
    }

    @Throws
    fun build(): Cellular {
        if ((::cellularObj.isInitialized.not())
        ) {
            throw DataNotSetException()
        }

        return cellularObj.apply instance@{
            val horizontalSv = HorizontalScrollView(context)

            columnCount?.let count@{ count: Int ->
                horizontalSv.addView(
                    addTableLayout(
                        context = context,
                        props = properties,
                        columnCount = count
                    )
                )

                this@instance.addView(horizontalSv)
            }
        }
    }

    private fun getHeaderProperties() {
        properties.headerProperties = HeaderProperties(
            headerBgColor = typedArray.getInt(
                R.styleable.Cellular_headerBgColor,
                R.color.header_color
            ),
            headerSpacing = typedArray.getInt(
                R.styleable.Cellular_headerSpacing,
                5
            ),
            headerTextSize = typedArray.getInt(
                R.styleable.Cellular_headerTextSize,
                14
            ),
            headerTextColor = typedArray.getInt(
                R.styleable.Cellular_headerTextColor,
                R.color.text_color
            ),
            headerTextMaxLines = typedArray.getInt(
                R.styleable.Cellular_headerTextMaxLines,
                1
            ),
            headerTextEllipsize = Ellipsize.entries.find {
                it.code == typedArray.getInt(
                    R.styleable.Cellular_headerTextEllipsize,
                    Ellipsize.NONE.code
                )
            } ?: Ellipsize.NONE,
            headerTextStyle = TextStyle.entries.find {
                it.code == typedArray.getInt(
                    R.styleable.Cellular_headerTextStyle,
                    TextStyle.NORMAL.code
                )
            } ?: TextStyle.NORMAL,
            headerTextGravity = Gravity.entries.find {
                it.code == typedArray.getInt(
                    R.styleable.Cellular_headerTextGravity,
                    Gravity.CENTER.code
                )
            } ?: Gravity.CENTER,
            headerIsAllCaps = typedArray.getBoolean(
                R.styleable.Cellular_headerTextAllCaps,
                false
            )
        )
    }

    private fun getContentProperties() {
        properties.contentProperties = ContentProperties(
            contentBgColor = typedArray.getInt(
                R.styleable.Cellular_contentBgColor,
                R.color.content_bg
            ),
            contentBgEffectColor = typedArray.getInt(
                R.styleable.Cellular_contentBgEffectColor,
                R.color.content_effect_bg
            ),
            contentSpacing = typedArray.getInt(
                R.styleable.Cellular_contentSpacing,
                5
            ),
            contentTextSize = typedArray.getInt(
                R.styleable.Cellular_contentTextSize,
                14
            ),
            contentTextColor = typedArray.getInt(
                R.styleable.Cellular_contentTextColor,
                R.color.text_color
            ),
            contentTextMaxLines = typedArray.getInt(
                R.styleable.Cellular_contentTextMaxLines,
                1
            ),
            contentTextEllipsize = Ellipsize.entries.find {
                it.code == typedArray.getInt(
                    R.styleable.Cellular_contentTextEllipsize,
                    Ellipsize.NONE.code
                )
            } ?: Ellipsize.NONE,
            contentTextStyle = TextStyle.entries.find {
                it.code == typedArray.getInt(
                    R.styleable.Cellular_contentTextStyle,
                    TextStyle.NORMAL.code
                )
            } ?: TextStyle.NORMAL,
            contentTextGravity = Gravity.entries.find {
                it.code == typedArray.getInt(
                    R.styleable.Cellular_contentTextGravity,
                    Gravity.CENTER.code
                )
            } ?: Gravity.CENTER,
            contentIsAllCaps = typedArray.getBoolean(
                R.styleable.Cellular_contentTextAllCaps,
                false
            )
        )
    }

    private fun getTypedArray(attrs: AttributeSet) {
        typedArray = context.obtainStyledAttributes(attrs, R.styleable.Cellular)
    }

    private fun getTableProperties() {
        properties.tableProperties = TableProperties(
            enableDivider = typedArray.getBoolean(R.styleable.Cellular_enableDivider, true),
            divResId = typedArray.getInt(R.styleable.Cellular_divResId, R.drawable.divider_white),
        )
    }
}