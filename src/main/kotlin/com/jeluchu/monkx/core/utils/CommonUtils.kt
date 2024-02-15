package com.jeluchu.monkx.core.utils

import org.jsoup.nodes.Document

fun extractValue(document: Document, label: String): String? {
    val row = document.select("div.chapterdetls2 table tbody tr:has(td.table1:contains($label))")

    if (row.size == 1) {
        return row.first()?.select("td:eq(1)")?.text().orEmpty()
    }

    return null
}