package com.tyupik.teating.business

import com.tyupik.teating.data.db.EatingEntity

interface IEatingRepository {

    suspend fun getEatingList(): List<EatingEntity>
    suspend fun postEating(item: EatingEntity)
    suspend fun removeItem(id: String)

}