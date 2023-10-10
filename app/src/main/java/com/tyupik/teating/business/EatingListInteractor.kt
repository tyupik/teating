package com.tyupik.teating.business

import android.content.res.Resources
import com.tyupik.teating.R
import com.tyupik.teating.data.db.EatingEntity
import com.tyupik.teating.ui.eating_list.model.EatingItem
import com.tyupik.teating.ui.eating_list.model.Side
import java.util.Date
import java.util.UUID
import javax.inject.Inject

class EatingListInteractor @Inject constructor(
    private val repository: IEatingRepository,
    private val resources: Resources,
) {

    suspend fun getEatingList(): List<EatingItem> {
        val list = repository.getEatingList()
        return list.map {
            EatingItem(
                id = it.id,
                dateAndTime = Date(it.dateMillis).toSimpleString(),
                side = resources.getString(
                    when (it.side) {
                        Side.LEFT -> R.string.left
                        Side.RIGHT -> R.string.right
                    }
                ),
                blobExist = it.blobExist
            )
        }
            .reversed()
    }

    suspend fun postEating(side: Side, isBlob: Boolean) {
        repository.postEating(
            EatingEntity(
                id = UUID.randomUUID().toString(),
                dateMillis = Date().time,
                side = side,
                blobExist = isBlob,
            )
        )
    }

    suspend fun removeItem(id: String) = repository.removeItem(id)

}