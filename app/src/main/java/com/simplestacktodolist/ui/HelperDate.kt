package com.simplestacktodolist.ui

import java.text.SimpleDateFormat

object HelperDate {

    fun getDateFromLong(date: Long): String {
        val sdf = SimpleDateFormat("EEE MMM d")
        return sdf.format(date)
    }
}
