package com.github.jameshnsears.brexitsoundboard.utils

import android.content.Context
import android.widget.Toast

object ToastHelper {
    private var toast: Toast? = null

    fun makeToast(context: Context, message: String) {
        if (toast != null) {
            toast!!.cancel()
        }
        toast = Toast.makeText(context, message, Toast.LENGTH_LONG)
        toast!!.show()
    }

    fun cancelToast() {
        if (toast != null) {
            toast!!.cancel()
            toast = null
        }
    }
}
