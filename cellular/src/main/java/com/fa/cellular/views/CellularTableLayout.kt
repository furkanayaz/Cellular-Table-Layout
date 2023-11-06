package com.fa.cellular.views

import android.content.Context
import android.view.View
import android.view.ViewGroup.LayoutParams
import android.widget.TableLayout
import com.fa.cellular.enums.Section
import com.fa.cellular.models.Properties

fun addTableLayout(context: Context, props: Properties, columnCount: Int): TableLayout =
    TableLayout(context).also {
        it.id = View.generateViewId()
        it.layoutParams = LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT)
        it.isStretchAllColumns = true

        if (props.enableDivider) {
            it.dividerDrawable = getDivColor(context, props.dividerColor)
            it.showDividers = TableLayout.SHOW_DIVIDER_MIDDLE
        }

        it.addView(
            addTableRow(
                context = context,
                props = props,
                sectionType = Section.HEADER
            )
        )

        val contentItems: List<List<String>> =
            props.contentProperties.getContentItems().chunked(size = columnCount)

        repeat(times = contentItems.size) { listIndex: Int ->
            it.addView(
                addTableRow(
                    context = context,
                    props = props.also { properties: Properties ->
                        properties.contentProperties.setContentItems(
                            items = contentItems[listIndex]
                        )
                    },
                    sectionType = Section.CONTENT
                )
            )
        }
    }