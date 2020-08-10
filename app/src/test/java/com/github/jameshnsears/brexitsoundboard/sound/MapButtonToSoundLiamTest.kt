package com.github.jameshnsears.brexitsoundboard.sound

import com.github.jameshnsears.brexitsoundboard.R
import org.junit.Test

class MapButtonToSoundLiamTest : AbstractMapButtonToSound() {
    @Test
    fun ensureButtonsPlayCorrectSounds() {
        keyValueMap[R.id.buttonLiamChickenObsessedMedia] = R.raw.liam_sound_chicken_obsessed_media
        keyValueMap[R.id.buttonLiamCitizensFirstNotPolitics] = R.raw.liam_sound_citizens_first_not_politics
        keyValueMap[R.id.buttonLiamEasiestInHumanHistory] = R.raw.liam_sound_easiest_in_human_history
        keyValueMap[R.id.buttonLiamNotHavingADealWouldBeBad] = R.raw.liam_sound_not_having_a_deal_would_be_bad
        keyValueMap[R.id.buttonLiamThisIsNotJustAboutEurope] = R.raw.liam_sound_this_is_not_just_about_europe
        keyValueMap[R.id.buttonLiamTooLazyAndTooFat] = R.raw.liam_sound_too_lazy_and_too_fat
        keyValueMap[R.id.buttonLiamWeCantBeBlackmailed] = R.raw.liam_sound_we_cant_be_blackmailed
        keyValueMap[R.id.buttonLiamSelfDefeating] = R.raw.liam_sound_self_defeating_pessimist
        keyValueMap[R.id.buttonLiamFullConfidenceInPM] = R.raw.liam_sound_full_confidence_in_pm
        keyValueMap[R.id.buttonLiamOldMenOfBrussels] = R.raw.liam_sound_old_men_of_brussels
        keyValueMap[R.id.buttonLiamRuleTakersSellout] = R.raw.liam_sound_rule_takers_sellout
        keyValueMap[R.id.buttonLiamShockTherapyRequiredForEu] = R.raw.liam_sound_shock_therapy_required_for_eu
        keyValueMap[R.id.buttonLiamStealingBrexit] = R.raw.liam_sound_stealing_brexit
        keyValueMap[R.id.buttonLiamAccessToEu] = R.raw.liam_sound_we_have_to_maintain_access_to_eu
        keyValueMap[R.id.buttonLiamThinkOfTheConsequences] = R.raw.liam_sound_think_of_the_political_consequences

        assertKeyValueMatch()
    }
}
