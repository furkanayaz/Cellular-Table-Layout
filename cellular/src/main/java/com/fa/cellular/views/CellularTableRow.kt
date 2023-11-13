package com.fa.cellular.views

import android.content.Context
import android.view.View
import android.widget.TableLayout
import android.widget.TableRow
import com.fa.cellular.R
import com.fa.cellular.enums.Section
import com.fa.cellular.models.Properties
import com.fa.cellular.models.getColor
import com.fa.cellular.models.getString
import com.fa.cellular.models.getDivDrawable

fun addTableRow(
    context: Context,
    props: Properties,
    sectionType: Section,
    rootView: TableLayout? = null,
    singleItem: List<String>? = null,
    isMultiItem: Boolean = true
): TableRow =
    TableRow(context).also {
        it.id = View.generateViewId()
        it.contentDescription = getString(context = context, resId = R.string.item_row)

        if (props.tableProperties.enableDivider) {
            it.dividerDrawable = getDivDrawable(context, props.tableProperties.divResId)
            it.showDividers = TableLayout.SHOW_DIVIDER_MIDDLE
        }

        when (sectionType) {
            Section.HEADER -> {
                it.setBackgroundColor(
                    getColor(
                        context = context,
                        resId = props.headerProperties.headerBgColor
                    )
                )

                val headerItems: List<String> = props.headerProperties.getHeaderItems()

                headerItems.forEach { text: String ->
                    it.addView(
                        addHeaderTextView(
                            context = context,
                            props = props.headerProperties,
                            text = text
                        )
                    )
                }
            }

            Section.CONTENT -> {
                if (isMultiItem) {
                    val contentItems: List<String> = props.contentProperties.getContentItems()

                    contentItems.forEach { text: String ->
                        it.addView(
                            addContentTextView(
                                context = context,
                                props = props.contentProperties,
                                text = text
                            )
                        )
                    }
                } else if (rootView != null && singleItem != null) {
                    singleItem.forEach { text: String ->
                        it.addView(
                            addContentTextView(
                                context = context,
                                props = props.contentProperties,
                                text = text
                            )
                        )
                    }
                }
            }
        }
    }