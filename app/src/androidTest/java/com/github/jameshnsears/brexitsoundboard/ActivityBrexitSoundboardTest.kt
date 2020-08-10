package com.github.jameshnsears.brexitsoundboard

import androidx.test.annotation.UiThreadTest
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.rule.ActivityTestRule
import org.junit.After
import org.junit.Assert
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class ActivityBrexitSoundboardTest {
    @get:Rule
    var activityBrexitSoundboard: ActivityTestRule<ActivityBrexitSoundboard> = ActivityTestRule(ActivityBrexitSoundboard::class.java)

    @Before
    @After
    fun sharedPreferencesEmpty() {
        activityBrexitSoundboard.activity.sharedPreferencesEmpty()
    }

    @Test
    @UiThreadTest
    fun checkOrderOfButtonImages() {
        var activeImageId = activityBrexitSoundboard.activity!!.setNextButtonImage(
            activityBrexitSoundboard.activity?.activityHomeBinding!!.imageButtonBoris00,
            activityBrexitSoundboard.activity.buttonIdsBoris
        )
        Assert.assertEquals(R.id.imageButtonBoris01.toLong(), activeImageId.toLong())

        // go back to first, from last
        activeImageId = activityBrexitSoundboard.activity!!.setNextButtonImage(
            activityBrexitSoundboard.activity?.activityHomeBinding!!.imageButtonBoris10,
            activityBrexitSoundboard.activity.buttonIdsBoris
        )
        Assert.assertEquals(R.id.imageButtonBoris00.toLong(), activeImageId.toLong())

        activeImageId = activityBrexitSoundboard.activity!!.setNextButtonImage(
            activityBrexitSoundboard.activity?.activityHomeBinding!!.imageButtonTheresa00,
            activityBrexitSoundboard.activity.buttonIdsTheresa
        )
        Assert.assertEquals(R.id.imageButtonTheresa01.toLong(), activeImageId.toLong())
    }
}
