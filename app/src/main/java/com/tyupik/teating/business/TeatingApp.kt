package com.tyupik.teating.business

import android.app.Application
import com.tyupik.teating.BuildConfig
import com.tyupik.teating.business.app_metric.Events
import com.yandex.metrica.YandexMetrica
import com.yandex.metrica.YandexMetricaConfig
import dagger.hilt.android.HiltAndroidApp


@HiltAndroidApp
class TeatingApp : Application() {

    override fun onCreate() {
        super.onCreate()
        initAppMetric()
    }

    private fun initAppMetric() {
        val config = YandexMetricaConfig.newConfigBuilder(API_KEY).build()
        YandexMetrica.activate(applicationContext, config)
        YandexMetrica.enableActivityAutoTracking(this)
        sendAppOpenEvent()
    }

    private fun sendAppOpenEvent() {
        val eventMessage = if (BuildConfig.DEBUG) {
            "debug_${Events.APP_OPEN_EVENT.name}"
        } else {
            Events.APP_OPEN_EVENT.name
        }
        YandexMetrica.reportEvent(eventMessage)
    }

}