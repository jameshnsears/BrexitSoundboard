package com.github.jameshnsears.brexitsoundboard.sound

import com.github.jameshnsears.brexitsoundboard.R
import org.junit.Test

class MapButtonToSoundBorisTest : AbstractMapButtonToSound() {
    @Test
    fun ensureButtonsPlayCorrectSounds() {
        keyValueMap[R.id.buttonBoris350MillionPoundsAWeek] = R.raw.boris_sound_350_million_pounds_a_week
        keyValueMap[R.id.buttonBorisAllYourOptionsAreGood] = R.raw.boris_sound_all_your_options_are_good
        keyValueMap[R.id.buttonBorisCostOfGettingOutVirtuallyNil] = R.raw.boris_sound_cost_of_getting_out_virtually_nil
        keyValueMap[R.id.buttonBorisHiggeldyPiggeldyNations] = R.raw.boris_sound_higgeldy_piggeldy_nations
        keyValueMap[R.id.buttonBorisTigerInTheTank] = R.raw.boris_sound_tiger_in_the_tank
        keyValueMap[R.id.buttonBorisVindicatedByHistory] = R.raw.boris_sound_vindicated_by_history
        keyValueMap[R.id.buttonBorisWeExportTvAerials] = R.raw.boris_sound_we_export_tv_aerials
        keyValueMap[R.id.buttonBorisWeightLiftedFromBritishBusiness] = R.raw.boris_sound_weight_lifted_from_british_business
        keyValueMap[R.id.buttonBorisWinWinForAllOfUs] = R.raw.boris_sound_win_win_for_all_off_us
        keyValueMap[R.id.buttonBorisLittleBenefitFromEU] = R.raw.boris_sound_little_benefit_from_single_market_and_customs_union
        keyValueMap[R.id.buttonBorisUkShapingTheModernWorld] = R.raw.boris_sound_uk_shaping_the_modern_world
        keyValueMap[R.id.buttonBorisBrexitHasNotDamagedCountry] = R.raw.boris_sound_brexit_has_not_damaged_our_country
        keyValueMap[R.id.buttonBorisDoNotUnderestimate] = R.raw.boris_sound_do_not_underestimate
        keyValueMap[R.id.buttonBorisAsLongAsItTakes] = R.raw.boris_sound_keep_going_for_as_long_as_it_takes
        keyValueMap[R.id.buttonBorisStunningSuccess] = R.raw.boris_sound_a_stunning_success
        keyValueMap[R.id.buttonBorisDeadInADitch] = R.raw.boris_sound_dead_in_a_ditch
        keyValueMap[R.id.buttonBorisFriendsAreABitNegative] = R.raw.boris_sound_friends_are_a_bit_negative
        keyValueMap[R.id.buttonBorisLetsGetBrexitDone] = R.raw.boris_sound_lets_get_brexit_done
        keyValueMap[R.id.buttonBorisNoNIChecks] = R.raw.boris_sound_no_ni_checks
        keyValueMap[R.id.buttonBorisPutItInTheMicrowave] = R.raw.boris_sound_put_it_in_the_microwave
        keyValueMap[R.id.buttonBorisWeHaveADeal] = R.raw.boris_sound_we_have_a_deal

        assertKeyValueMatch()
    }
}
