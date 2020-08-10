package com.github.jameshnsears.brexitsoundboard.sound

import com.github.jameshnsears.brexitsoundboard.R
import org.junit.Test

class MapButtonToSoundTheresaTest : AbstractMapButtonToSound() {
    @Test
    fun ensureButtonsPlayCorrectSounds() {
        keyValueMap[R.id.buttonTheresaBrexitMeansBrexit] = R.raw.theresa_sound_brexit_means_brexit
        keyValueMap[R.id.buttonTheresaNoDealBetterThanABadDeal] = R.raw.theresa_sound_no_deal_better_than_a_bad_deal
        keyValueMap[R.id.buttonTheresaNoNeedForAnElection] = R.raw.theresa_sound_no_need_for_an_election
        keyValueMap[R.id.buttonTheresaRedWhiteAndBlueBrexit] = R.raw.theresa_sound_red_white_and_blue_brexit
        keyValueMap[R.id.buttonTheresaStrongAndStableLeadership] = R.raw.theresa_sound_strong_and_stable_leadership
        keyValueMap[R.id.buttonTheresAPlan] = R.raw.theresa_sound_a_plan_for_britain
        keyValueMap[R.id.buttonTheresaCertaintyAndClarity] = R.raw.theresa_sound_certainty_and_clarity
        keyValueMap[R.id.buttonTheresaWeShouldStayInTheEu] = R.raw.theresa_sound_we_should_stay_inside_eu
        keyValueMap[R.id.buttonTheresaNIisPartOfTheUK] = R.raw.theresa_sound_ni_is_part_of_the_uk
        keyValueMap[R.id.buttonTheresaIWillNeverAgreeTo] = R.raw.theresa_sound_something_i_will_never_agree_to
        keyValueMap[R.id.buttonTheresaCitizenOfNowhere] = R.raw.theresa_sound_citizen_of_nowhere

        assertKeyValueMatch()
    }
}
