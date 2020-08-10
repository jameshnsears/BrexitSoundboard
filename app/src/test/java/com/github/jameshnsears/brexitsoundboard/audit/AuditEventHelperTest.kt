package com.github.jameshnsears.brexitsoundboard.audit

import android.app.Application
import io.mockk.every
import io.mockk.mockkObject
import org.junit.Test
import java.util.concurrent.ConcurrentHashMap

class AuditEventHelperTest {
    @Test
    fun createAnAuditEvent() {
        mockkObject(AuditEventHelper.Companion)

        every { AuditEventHelper.createInstance(Application()) } answers { nothing }
        every { AuditEventHelper.trackEvent(String(), ConcurrentHashMap()) } answers { nothing }

        AuditEventHelper.auditEvent(AuditEventHelper.Event.PERSON, "person")
        AuditEventHelper.auditEvent(AuditEventHelper.Event.SOUND, "sound")
        AuditEventHelper.auditEvent(AuditEventHelper.Event.MEDIA_LIBRARY, "media library")
    }
}
