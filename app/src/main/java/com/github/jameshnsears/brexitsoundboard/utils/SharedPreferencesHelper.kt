package com.github.jameshnsears.brexitsoundboard.utils

import android.content.Context
import android.content.SharedPreferences

object SharedPreferencesHelper {
    private var SHARED_PREFERENCES_NAME = "BrexitSoundboard"
    var INSTALL_SOUND = "installSoundIntoMediaLibrary"
    var SELECTED_BUTTONID_BORIS = "currentBorisButtonId"
    var SELECTED_BUTTONID_LIAM = "currentLiamButtonId"
    var SELECTED_BUTTONID_DAVID = "currentDavidButtonId"
    var SELECTED_BUTTONID_THERESA = "currentTheresaButtonId"
    var SELECTED_BUTTONID_JACOB = "currentJacobButtonId"

    fun getSharedPreferences(context: Context): SharedPreferences {
        return context.getSharedPreferences(SHARED_PREFERENCES_NAME, Context.MODE_PRIVATE)
    }

    fun isInstallSoundEnabled(context: Context): Boolean {
        return getSharedPreferences(context).getBoolean(INSTALL_SOUND, false)
    }
}
