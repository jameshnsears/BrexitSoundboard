package com.github.jameshnsears.brexitsoundboard

import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import na.brexitsoundboard.R
import org.junit.After
import org.junit.Assert
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class ActivityBrexitSoundboardTest {
    @get:Rule
    var activityScenarioRule = ActivityScenarioRule(ActivityBrexitSoundboard::class.java)

    @Before
    @After
    fun sharedPreferencesEmpty() {
        activityScenarioRule.scenario.onActivity { it.sharedPreferencesEmpty() }
    }

    @Test
    fun checkOrderOfButtonImages() {
        activityScenarioRule.scenario.onActivity { activity ->
            var activeImageId =
                activity.setNextButtonImage(
                    activity.activityHomeBinding!!.imageButtonBoris00,
                    activity.buttonIdsBoris,
                )
            Assert.assertEquals(R.id.imageButtonBoris01.toLong(), activeImageId.toLong())

            // go back to first, from last
            activeImageId =
                activity.setNextButtonImage(
                    activity.activityHomeBinding!!.imageButtonBoris10,
                    activity.buttonIdsBoris,
                )
            Assert.assertEquals(R.id.imageButtonBoris00.toLong(), activeImageId.toLong())

            activeImageId =
                activity.setNextButtonImage(
                    activity.activityHomeBinding!!.imageButtonTheresa00,
                    activity.buttonIdsTheresa,
                )
            Assert.assertEquals(R.id.imageButtonTheresa01.toLong(), activeImageId.toLong())
        }
    }
}
