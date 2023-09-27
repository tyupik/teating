package com.tyupik.teating.data

import com.tyupik.teating.business.IEatingRepository
import com.tyupik.teating.data.db.EatingDao
import com.tyupik.teating.data.db.EatingEntity
import javax.inject.Inject

class EatingRepository @Inject constructor(
    private val dao: EatingDao,
): IEatingRepository {

    override suspend fun getEatingList(): List<EatingEntity> = dao.getEatingList()

    override suspend fun postEating(item: EatingEntity) = dao.insert(item)

    override suspend fun removeItem(id: String) = dao.delete(id)

}