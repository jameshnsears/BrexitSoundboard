package com.github.jameshnsears.brexitsoundboard.sound

import android.content.Context
import android.media.MediaPlayer
import timber.log.Timber

/**
 * Helper class to manage MediaPlayer lifecycle and simplify playing sounds from raw resources.
 */
class MediaPlayerHelper {
    private var mediaPlayer: MediaPlayer? = null

    /**
     * Stops and releases the current MediaPlayer instance.
     */
    fun reset() {
        mediaPlayer?.let { player ->
            try {
                if (player.isPlaying) {
                    player.stop()
                }
            } catch (e: IllegalStateException) {
                // MediaPlayer was not in a state where stop() could be called.
            } catch (e: Exception) {
                Timber.e(e, "Error resetting MediaPlayer")
            } finally {
                player.release()
                mediaPlayer = null
            }
        }
    }

    /**
     * Plays a sound from a raw resource. Resets any currently playing sound first.
     */
    fun play(
        context: Context,
        rawSoundId: Int,
    ) {
        reset()
        try {
            mediaPlayer =
                MediaPlayer.create(context, rawSoundId)?.apply {
                    setOnCompletionListener {
                        reset()
                    }
                    setOnErrorListener { _, what, extra ->
                        Timber.e("MediaPlayer error: what=$what, extra=$extra")
                        reset()
                        true
                    }
                    start()
                }
            if (mediaPlayer == null) {
                Timber.e("Failed to create MediaPlayer for resource ID: %d", rawSoundId)
            }
        } catch (e: Exception) {
            Timber.e(e, "Exception while playing sound")
            reset()
        }
    }
}
