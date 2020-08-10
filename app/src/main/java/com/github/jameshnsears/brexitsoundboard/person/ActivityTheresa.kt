package com.github.jameshnsears.brexitsoundboard.person

import android.os.Bundle
import com.github.jameshnsears.brexitsoundboard.R

class ActivityTheresa : AbstractActivityPerson() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_theresa)
        registerClickListener(R.id.buttonTheresaWeShouldStayInTheEu)
        registerClickListener(R.id.buttonTheresaCitizenOfNowhere)
        registerClickListener(R.id.buttonTheresAPlan)
        registerClickListener(R.id.buttonTheresaBrexitMeansBrexit)
        registerClickListener(R.id.buttonTheresaRedWhiteAndBlueBrexit)
        registerClickListener(R.id.buttonTheresaCertaintyAndClarity)
        registerClickListener(R.id.buttonTheresaNoDealBetterThanABadDeal)
        registerClickListener(R.id.buttonTheresaNoNeedForAnElection)
        registerClickListener(R.id.buttonTheresaStrongAndStableLeadership)
        registerClickListener(R.id.buttonTheresaNIisPartOfTheUK)
        registerClickListener(R.id.buttonTheresaIWillNeverAgreeTo)
    }
}
