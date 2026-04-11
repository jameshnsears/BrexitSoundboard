package com.github.jameshnsears.brexitsoundboard.sound

import android.view.View
import io.mockk.every
import io.mockk.mockk
import org.junit.Assert

abstract class AbstractMapButtonToSound {
    val keyValueMap = mutableMapOf<Int, Int>()

    fun assertKeyValueMatch() {
        val mapButtonToSound = MapButtonToSound()
        val view = mockk<View>()

        for ((key, value) in keyValueMap) {
            every { view.id } returns key
            Assert.assertEquals(value, mapButtonToSound.buttonIdToSoundIdMap[view.id])
        }
    }
}
