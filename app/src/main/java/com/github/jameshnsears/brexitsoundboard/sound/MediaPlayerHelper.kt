package com.github.jameshnsears.brexitsoundboard.sound

import android.app.Activity
import android.media.MediaPlayer
import timber.log.Timber

class MediaPlayerHelper {
    private var mediaPlayer: MediaPlayer? = null

    fun reset() {
        try {
            if (mediaPlayer != null && mediaPlayer!!.isPlaying) {
                mediaPlayer!!.stop()
                mediaPlayer!!.release()
            }
        } catch (e: Exception) {
            Timber.e(e.message)
        }
    }

    fun play(activity: Activity?, rawSoundId: Int) {
        Timber.d("playMediaFile")
        try {
            mediaPlayer = MediaPlayer.create(activity, rawSoundId)
            mediaPlayer?.start()
        } catch (e: Exception) {
            Timber.d(String.format("%s", e.message))
            reset()
            play(activity, rawSoundId)
        }
    }
}
