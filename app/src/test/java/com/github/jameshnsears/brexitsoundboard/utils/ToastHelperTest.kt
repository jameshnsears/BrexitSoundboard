package com.github.jameshnsears.brexitsoundboard.utils

import android.content.Context
import android.widget.Toast
import io.mockk.every
import io.mockk.mockk
import io.mockk.mockkObject
import org.junit.Test

class ToastHelperTest {
    @Test
    fun makeToast() {
        mockkObject(ToastHelper)

        val mockToast = mockk<Toast>()
        every { mockToast.cancel() } returns Unit
        every { mockToast.show() } returns Unit

        every { ToastHelper.buildToast(any(), any()) } returns mockToast

        ToastHelper.makeToast(mockk<Context>(), "")
        ToastHelper.cancelToast()
    }
}
