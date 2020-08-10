package com.github.jameshnsears.brexitsoundboard.audit

import android.app.Application
import android.os.Bundle
import com.github.jameshnsears.brexitsoundboard.BuildConfig
import com.google.firebase.analytics.FirebaseAnalytics
import com.microsoft.appcenter.AppCenter
import com.microsoft.appcenter.analytics.Analytics
import com.microsoft.appcenter.crashes.Crashes
import timber.log.Timber
import java.util.concurrent.ConcurrentHashMap

class AuditEventHelper private constructor(application: Application) {
    enum class Event {
        PERSON, SOUND, MEDIA_LIBRARY
    }

    companion object {
        private var auditEventHelperSingleton: AuditEventHelper? = null
        private var firebaseAnalytics: FirebaseAnalytics? = null

        @Synchronized
        fun createInstance(application: Application) {
            if (auditEventHelperSingleton == null) {
                auditEventHelperSingleton = AuditEventHelper(application)
                firebaseAnalytics = FirebaseAnalytics.getInstance(application.applicationContext)
            }
        }

        fun auditEvent(event: Event?, value: String) {
            val auditProperties = ConcurrentHashMap<String, String>()
            var keyName = ""
            when (event) {
                Event.SOUND -> keyName = "SOUND"
                Event.MEDIA_LIBRARY -> keyName = "MEDIA_LIBRARY"
                else -> {
                    keyName = "PERSON"
                }
            }
            auditProperties[keyName] = value
            trackEvent(keyName, auditProperties)
        }

        fun trackEvent(keyName: String, auditProperties: ConcurrentHashMap<String, String>) {
            // adb uninstall na.brexitsoundboard

            // on
            // adb shell setprop debug.firebase.analytics.app na.brexitsoundboard

            // off
            // adb shell setprop debug.firebase.analytics.app .none.
            val bundle = Bundle()
            for (entry in auditProperties.entries) {
                // https://firebase.google.com/docs/reference/android/com/google/firebase/analytics/FirebaseAnalytics#logEvent(java.lang.String,%20android.os.Bundle)
                var key = entry.key
                if (key.length > 40) {
                    key = key.substring(0, 40)
                }
                var value = entry.value
                if (value.length > 100) {
                    value = value.substring(0, 100)
                }
                Timber.d("%s=%s", key, value)
                bundle.putString(key, value)
            }

            firebaseAnalytics?.logEvent(keyName, bundle)

            Analytics.trackEvent(keyName, auditProperties)
        }
    }

    init {
        AppCenter.start(
            application,
            BuildConfig.APPCENTER_KEY,
            Analytics::class.java,
            Crashes::class.java
        )
    }
}
