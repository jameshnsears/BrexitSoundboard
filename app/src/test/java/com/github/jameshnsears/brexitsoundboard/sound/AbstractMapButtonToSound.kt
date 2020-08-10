package com.github.jameshnsears.brexitsoundboard.sound

import android.view.View
import org.junit.Assert
import org.mockito.Mockito

abstract class AbstractMapButtonToSound {
    val keyValueMap = mutableMapOf<Int, Int>()

    fun assertKeyValueMatch() {
        val mapButtonToSound = MapButtonToSound()
        val view = Mockito.mock(View::class.java)

        for ((key, value) in keyValueMap) {
            // "when" is a reserved keyword, ` used to differentiate it
            Mockito.`when`(view.id).thenReturn(key)
            Assert.assertEquals(value, mapButtonToSound.buttonIdToSoundIdMap[view.id])
        }
    }
}
