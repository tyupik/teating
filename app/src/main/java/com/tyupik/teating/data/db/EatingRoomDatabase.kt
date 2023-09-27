package com.tyupik.teating.data.db

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(
    entities = [EatingEntity::class],
    version = 2,
)
abstract class EatingRoomDatabase : RoomDatabase() {

    abstract fun eatingDao(): EatingDao

}