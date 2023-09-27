package com.tyupik.teating.business

import java.text.SimpleDateFormat
import java.util.Date

fun Date.toSimpleString(): String {
    val format = SimpleDateFormat("HH:mm dd/MM/yyyy")
    return format.format(this)
}