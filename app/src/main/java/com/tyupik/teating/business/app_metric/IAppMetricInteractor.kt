package com.tyupik.teating.business.app_metric

interface IAppMetricInteractor {

    suspend fun sendSimpleEvent(event: Events)

}