package com.tyupik.teating.data.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface EatingDao {

    @Query("SELECT * FROM eating_list")
    suspend fun getEatingList(): List<EatingEntity>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(item: EatingEntity)

    @Query("DELETE FROM eating_list WHERE id = :id")
    suspend fun delete(id: String)

}