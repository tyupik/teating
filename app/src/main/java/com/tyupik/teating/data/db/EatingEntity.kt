package com.tyupik.teating.data.db

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.tyupik.teating.ui.eating_list.model.Side

@Entity(tableName = "eating_list")
data class EatingEntity(
    @PrimaryKey
    val id: String,
    val dateMillis: Long,
    val side: Side,
)