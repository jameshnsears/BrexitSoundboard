package com.github.jameshnsears.brexitsoundboard.person

import android.view.KeyEvent
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.github.jameshnsears.brexitsoundboard.audit.AuditEventHelper
import com.github.jameshnsears.brexitsoundboard.audit.AuditEventHelper.Companion.auditEvent
import com.github.jameshnsears.brexitsoundboard.sound.MapButtonToSound
import com.github.jameshnsears.brexitsoundboard.sound.MediaPlayerHelper
import com.github.jameshnsears.brexitsoundboard.utils.SharedPreferencesHelper.isInstallSoundEnabled
import com.github.jameshnsears.brexitsoundboard.utils.ToastHelper
import timber.log.Timber

abstract class AbstractActivityPerson : AppCompatActivity(), View.OnClickListener {
    private val mapButtonToSound = MapButtonToSound()

    private val mediaPlayerHelper = MediaPlayerHelper()

    fun registerClickListener(buttonId: Int) {
        findViewById<Button>(buttonId).setOnClickListener(this)
        if (isInstallSoundEnabled(this)) {
            registerForContextMenu(findViewById(buttonId))
        }
    }

    override fun onClick(view: View) {
        soundPlay(
            mapButtonToSound.buttonIdToSoundIdMap[view.id]!!,
            findViewById<Button>(view.id).text.toString()
        )
    }

    override fun onDestroy() {
        super.onDestroy()
        ToastHelper.cancelToast()
    }

    private fun soundPlay(rawSoundId: Int, nameOfSound: String) {
        Timber.d(nameOfSound)

        auditEvent(AuditEventHelper.Event.SOUND, nameOfSound)

        mediaPlayerHelper.reset()
        mediaPlayerHelper.play(this, rawSoundId)
    }

    override fun onKeyDown(keyCode: Int, event: KeyEvent): Boolean {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            mediaPlayerHelper.reset()
        }
        return super.onKeyDown(keyCode, event)
    }
}
