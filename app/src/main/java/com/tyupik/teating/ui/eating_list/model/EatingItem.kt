package com.tyupik.teating.ui.eating_list.model

data class EatingItem(
    val id: String,
    val dateAndTime: String,
    val side: String,
    val blobExist: Boolean,
)

enum class Side {
    LEFT,
    RIGHT,
}