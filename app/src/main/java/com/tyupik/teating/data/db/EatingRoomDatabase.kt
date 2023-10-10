package com.tyupik.teating.data.db

import androidx.room.AutoMigration
import androidx.room.Database
import androidx.room.RoomDatabase

@Database(
    entities = [EatingEntity::class],
    version = 3,
    autoMigrations = [
        AutoMigration (from = 2, to = 3),
    ]
)
abstract class EatingRoomDatabase : RoomDatabase() {

    abstract fun eatingDao(): EatingDao

}