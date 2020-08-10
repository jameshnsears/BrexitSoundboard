package com.github.jameshnsears.brexitsoundboard.sound

import com.github.jameshnsears.brexitsoundboard.R
import org.junit.Test

class MapButtonToSoundDavidTest : AbstractMapButtonToSound() {
    @Test
    fun ensureButtonsPlayCorrectSounds() {
        keyValueMap[R.id.buttonDavidAgreementWillFavourTheEU] = R.raw.david_sound_agreement_will_favour_the_eu
        keyValueMap[R.id.buttonDavidConfidentOfAGoodOutcome] = R.raw.david_sound_confident_of_a_good_outcome
        keyValueMap[R.id.buttonDavidDifficultToReadWhatWeIntend] = R.raw.david_sound_difficult_to_read_what_we_intend
        keyValueMap[R.id.buttonDavidFollowUs] = R.raw.david_sound_follow_us
        keyValueMap[R.id.buttonDavidIRuleNothingInNothingOut] = R.raw.david_sound_i_rule_nothing_in_nothing_out
        keyValueMap[R.id.buttonDavidItsGettingABitTense] = R.raw.david_sound_its_getting_a_bit_tense
        keyValueMap[R.id.buttonDavidItsGoingIncrediblyWell] = R.raw.david_sound_its_going_incredibly_well
        keyValueMap[R.id.buttonDavidNobodyPretendedThisWillBeSimpleOrEasy] = R.raw.david_sound_nobody_pretended_this_will_be_simple_or_easy
        keyValueMap[R.id.buttonDavidVeryGoodLawyers] = R.raw.david_sound_very_good_lawyers
        keyValueMap[R.id.buttonDavidSectorialAnalysis] = R.raw.david_sound_sectorial_analysis
        keyValueMap[R.id.buttonDavidOnlyLastTwoMonthsMatter] = R.raw.david_sound_only_last_two_months_matter
        keyValueMap[R.id.buttonDavidTheRiskIsWorthIt] = R.raw.david_sound_the_risk_is_worth_it
        keyValueMap[R.id.buttonDavidDamageWorseForEurope] = R.raw.david_sound_damage_worse_for_europe
        keyValueMap[R.id.buttonDavidTrumpMoment] = R.raw.david_sound_trump_moment
        keyValueMap[R.id.buttonDavidDoNotBlameMe] = R.raw.david_sound_not_about_blame
        keyValueMap[R.id.buttonDavidWeCanLookAfterOurselves] = R.raw.david_sound_we_can_look_after_ourselves

        assertKeyValueMatch()
    }
}
