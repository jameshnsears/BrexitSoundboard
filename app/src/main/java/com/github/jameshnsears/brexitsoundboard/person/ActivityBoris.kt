package com.github.jameshnsears.brexitsoundboard.person

import android.os.Bundle
import com.github.jameshnsears.brexitsoundboard.R

class ActivityBoris : AbstractActivityPerson() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        supportActionBar?.hide()

        setContentView(R.layout.activity_boris)
        registerClickListener(R.id.buttonBoris350MillionPoundsAWeek)
        registerClickListener(R.id.buttonBorisHiggeldyPiggeldyNations)
        registerClickListener(R.id.buttonBorisWeExportTvAerials)
        registerClickListener(R.id.buttonBorisLittleBenefitFromEU)
        registerClickListener(R.id.buttonBorisAllYourOptionsAreGood)
        registerClickListener(R.id.buttonBorisCostOfGettingOutVirtuallyNil)
        registerClickListener(R.id.buttonBorisWeightLiftedFromBritishBusiness)
        registerClickListener(R.id.buttonBorisWinWinForAllOfUs)
        registerClickListener(R.id.buttonBorisBrexitHasNotDamagedCountry)
        registerClickListener(R.id.buttonBorisUkShapingTheModernWorld)
        registerClickListener(R.id.buttonBorisTigerInTheTank)
        registerClickListener(R.id.buttonBorisAsLongAsItTakes)
        registerClickListener(R.id.buttonBorisDoNotUnderestimate)
        registerClickListener(R.id.buttonBorisVindicatedByHistory)
        registerClickListener(R.id.buttonBorisDeadInADitch)
        registerClickListener(R.id.buttonBorisFriendsAreABitNegative)
        registerClickListener(R.id.buttonBorisLetsGetBrexitDone)
        registerClickListener(R.id.buttonBorisNoNIChecks)
        registerClickListener(R.id.buttonBorisProsperMightily)
        registerClickListener(R.id.buttonBorisWeHaveADeal)
        registerClickListener(R.id.buttonBorisPutItInTheMicrowave)
        registerClickListener(R.id.buttonBorisStunningSuccess)
        registerClickListener(R.id.buttonBorisCakistTreaty)
        registerClickListener(R.id.buttonBorisFantasticDealForAll)
        registerClickListener(R.id.buttonBorisFullControlOfWaters)
        registerClickListener(R.id.buttonBorisMoreBusinessWithEU)
        registerClickListener(R.id.buttonBorisNoNonTariffBarriers)
        registerClickListener(R.id.buttonBorisSandpaperingTheBarnacles)
        registerClickListener(R.id.buttonBorisFacingARealProblem)
        registerClickListener(R.id.buttonBorisIgnoreMerchantsOfGloom)
        registerClickListener(R.id.buttonBorisNoImpedimentToOurExports)
        registerClickListener(R.id.buttonBorisBrexitAndUkraineSimilar)
    }
}
