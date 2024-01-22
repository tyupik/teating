package com.tyupik.teating.business.app_metric

import com.tyupik.teating.BuildConfig
import com.yandex.metrica.YandexMetrica
import javax.inject.Inject

class AppMetricInteractor @Inject constructor() : IAppMetricInteractor {

    override suspend fun sendSimpleEvent(event: Events) {
        val eventMessage = if (BuildConfig.DEBUG) {
            "debug_${event.name}"
        } else {
            event.name
        }
        YandexMetrica.reportEvent(eventMessage)
    }

}