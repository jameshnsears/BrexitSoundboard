package com.github.jameshnsears.brexitsoundboard.person

import android.os.Bundle
import com.github.jameshnsears.brexitsoundboard.R

class ActivityLiam : AbstractActivityPerson() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_liam)
        registerClickListener(R.id.buttonLiamCitizensFirstNotPolitics)
        registerClickListener(R.id.buttonLiamEasiestInHumanHistory)
        registerClickListener(R.id.buttonLiamTooLazyAndTooFat)
        registerClickListener(R.id.buttonLiamThisIsNotJustAboutEurope)
        registerClickListener(R.id.buttonLiamOldMenOfBrussels)
        registerClickListener(R.id.buttonLiamShockTherapyRequiredForEu)
        registerClickListener(R.id.buttonLiamSelfDefeating)
        registerClickListener(R.id.buttonLiamChickenObsessedMedia)
        registerClickListener(R.id.buttonLiamAccessToEu)
        registerClickListener(R.id.buttonLiamNotHavingADealWouldBeBad)
        registerClickListener(R.id.buttonLiamFullConfidenceInPM)
        registerClickListener(R.id.buttonLiamRuleTakersSellout)
        registerClickListener(R.id.buttonLiamStealingBrexit)
        registerClickListener(R.id.buttonLiamWeCantBeBlackmailed)
        registerClickListener(R.id.buttonLiamThinkOfTheConsequences)
    }
}
