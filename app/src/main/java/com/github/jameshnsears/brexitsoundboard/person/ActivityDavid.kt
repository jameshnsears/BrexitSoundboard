package com.github.jameshnsears.brexitsoundboard.person

import android.os.Bundle
import com.github.jameshnsears.brexitsoundboard.R

class ActivityDavid : AbstractActivityPerson() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_david)
        registerClickListener(R.id.buttonDavidConfidentOfAGoodOutcome)
        registerClickListener(R.id.buttonDavidTheRiskIsWorthIt)
        registerClickListener(R.id.buttonDavidIRuleNothingInNothingOut)
        registerClickListener(R.id.buttonDavidDifficultToReadWhatWeIntend)
        registerClickListener(R.id.buttonDavidItsGoingIncrediblyWell)
        registerClickListener(R.id.buttonDavidItsGettingABitTense)
        registerClickListener(R.id.buttonDavidVeryGoodLawyers)
        registerClickListener(R.id.buttonDavidNobodyPretendedThisWillBeSimpleOrEasy)
        registerClickListener(R.id.buttonDavidSectorialAnalysis)
        registerClickListener(R.id.buttonDavidOnlyLastTwoMonthsMatter)
        registerClickListener(R.id.buttonDavidFollowUs)
        registerClickListener(R.id.buttonDavidDamageWorseForEurope)
        registerClickListener(R.id.buttonDavidAgreementWillFavourTheEU)
        registerClickListener(R.id.buttonDavidTrumpMoment)
        registerClickListener(R.id.buttonDavidDoNotBlameMe)
        registerClickListener(R.id.buttonDavidWeCanLookAfterOurselves)
        registerClickListener(R.id.buttonDavidNoDownsideToBrexit)
    }
}
