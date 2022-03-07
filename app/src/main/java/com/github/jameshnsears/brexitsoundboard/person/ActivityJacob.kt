package com.github.jameshnsears.brexitsoundboard.person

import android.os.Bundle
import com.github.jameshnsears.brexitsoundboard.R

class ActivityJacob : AbstractActivityPerson() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_jacob)
        registerClickListener(R.id.buttonJacobPerilsOfForecasting)
        registerClickListener(R.id.buttonJacobFiftyYearTimescale)
        registerClickListener(R.id.buttonJacobHappyBritishFish)
        registerClickListener(R.id.buttonJacobDailyPrayer)
        registerClickListener(R.id.buttonJacobMinisterForBrexitOpportunities)
    }
}
