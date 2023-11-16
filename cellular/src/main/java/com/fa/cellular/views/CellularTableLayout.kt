package com.fa.cellular.views

import android.content.Context
import android.view.View
import android.view.ViewGroup.LayoutParams
import android.widget.TableLayout
import android.widget.TableRow
import com.fa.cellular.R
import com.fa.cellular.enums.Section
import com.fa.cellular.models.Properties
import com.fa.cellular.models.getColor
import com.fa.cellular.models.getString
import com.fa.cellular.models.getDivDrawable

internal fun addTableLayout(context: Context, props: Properties, columnCount: Int): TableLayout =
    TableLayout(context).also {
        it.id = View.generateViewId()
        it.contentDescription = getString(context = context, resId = R.string.items_table)
        it.layoutParams = LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT)
        it.isStretchAllColumns = true

        if (props.tableProperties.enableDivider) {
            it.dividerDrawable = getDivDrawable(context, props.tableProperties.divResId)
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
                ).also { row: TableRow ->
                    row.setBackgroundColor(
                        getColor(
                            context = context,
                            resId = if ((listIndex % 2) == 0) props.contentProperties.contentBgColor else props.contentProperties.contentBgEffectColor
                        )
                    )
                }
            )
        }
    }