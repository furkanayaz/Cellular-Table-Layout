package com.fa.cellular.views

import android.content.Context
import android.view.View
import android.widget.TableLayout
import android.widget.TableRow
import com.fa.cellular.enums.Section
import com.fa.cellular.models.Properties
import com.fa.cellular.models.getColorFromPallet

fun addTableRow(
    context: Context,
    props: Properties,
    sectionType: Section
): TableRow =
    TableRow(context).also {
        it.id = View.generateViewId()

        if (props.enableDivider) {
            it.dividerDrawable = getDivColor(context, props.dividerColor)
            it.showDividers = TableLayout.SHOW_DIVIDER_MIDDLE
        }

        when (sectionType) {
            Section.HEADER -> {
                it.setBackgroundColor(getColorFromPallet(context, props.headerProperties.headerBgColor))

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
                it.setBackgroundColor(
                    getColorFromPallet(
                        context,
                        props.contentProperties.contentBgColor
                    )
                )

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
            }
        }
    }