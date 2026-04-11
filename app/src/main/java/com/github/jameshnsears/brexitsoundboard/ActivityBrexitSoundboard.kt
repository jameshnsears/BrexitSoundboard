package com.github.jameshnsears.brexitsoundboard

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ImageButton
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.edit
import androidx.core.net.toUri
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.github.jameshnsears.brexitsoundboard.audit.AuditEventHelper
import com.github.jameshnsears.brexitsoundboard.audit.AuditEventHelper.Companion.auditEvent
import com.github.jameshnsears.brexitsoundboard.audit.AuditEventHelper.Companion.createInstance
import com.github.jameshnsears.brexitsoundboard.person.ActivityBoris
import com.github.jameshnsears.brexitsoundboard.person.ActivityDavid
import com.github.jameshnsears.brexitsoundboard.person.ActivityJacob
import com.github.jameshnsears.brexitsoundboard.person.ActivityLiam
import com.github.jameshnsears.brexitsoundboard.person.ActivityTheresa
import com.github.jameshnsears.brexitsoundboard.sound.MediaPlayerHelper
import com.github.jameshnsears.brexitsoundboard.utils.SharedPreferencesHelper
import com.github.jameshnsears.brexitsoundboard.utils.SharedPreferencesHelper.getSharedPreferences
import com.github.jameshnsears.brexitsoundboard.utils.TimberDebugTree
import na.brexitsoundboard.BuildConfig
import na.brexitsoundboard.R
import na.brexitsoundboard.databinding.ActivityHomeBinding
import timber.log.Timber
import java.util.Locale

class ActivityBrexitSoundboard : AppCompatActivity() {
    val buttonIdsBoris: MutableList<Int> = ArrayList()
    private val buttonIdsLiam: MutableList<Int> = ArrayList()
    private val buttonIdsDavid: MutableList<Int> = ArrayList()
    val buttonIdsTheresa: MutableList<Int> = ArrayList()
    private val buttonIdsJacob: MutableList<Int> = ArrayList()

    private var imageButtonClickedOn: ImageButton? = null
    private var selectedButtonIdBoris = 0
    private var selectedButtonIdLiam = 0
    private var selectedButtonIdDavid = 0
    private var selectedButtonIdTheresa = 0
    private var selectedButtonIdJacob = 0
    private val mediaPlayerHelper = MediaPlayerHelper()

    enum class ButtonType {
        BORIS,
        LIAM,
        DAVID,
        THERESA,
        JACOB,
    }

    var activityHomeBinding: ActivityHomeBinding? = null

    fun sharedPreferencesEmpty() {
        getSharedPreferences(this).edit { clear() }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        // 1. Enable Edge-to-Edge BEFORE super.onCreate
        enableEdgeToEdge()

        super.onCreate(savedInstanceState)

        if (BuildConfig.DEBUG) {
            Timber.plant(TimberDebugTree())
        }

        activityHomeBinding = ActivityHomeBinding.inflate(layoutInflater)
        val view: View = activityHomeBinding!!.root
        setContentView(view)

        // 2. Handle System Bar Insets
        // This ensures your content isn't cut off by the camera cutout or navigation bar
        ViewCompat.setOnApplyWindowInsetsListener(view) { v, windowInsets ->
            val systemBars = windowInsets.getInsets(WindowInsetsCompat.Type.systemBars())
            // Apply padding to the root view so it respects the status/nav bar areas
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            windowInsets
        }

        // Hide Action Bar if it exists
        supportActionBar?.hide()

        initAuditing()
        setFooterVersion()
        registerClickListenersForImageButtons()
        registerClickListenerWikipedia()
        registerClickListenerFooter()
        sharedPreferencesRestore()
    }

    // entered from Activity[Person]
    override fun onResume() {
        super.onResume()

        mediaPlayerHelper.reset()
        if (imageButtonClickedOn != null) {
            setButtonImage(imageButtonClickedOn!!)

            sharedPreferencesSave()
        }
    }

    private fun initAuditing() {
        createInstance(application)
    }

    private fun setFooterVersion() {
        activityHomeBinding!!.textViewVersion.text =
            resources.getString(
                R.string.footer_version,
                BuildConfig.VERSION_NAME,
                BuildConfig.GIT_HASH,
            )
    }

    private fun registerClickListenersForImageButtons() {
        registerButtonBoris()
        registerButtonDavid()
        registerButtonLiam()
        registerButtonTheresa()
        registerButtonJacob()
    }

    private fun registerButtonBoris() {
        buttonIdsBoris.add(activityHomeBinding!!.imageButtonBoris00.id)
        buttonIdsBoris.add(activityHomeBinding!!.imageButtonBoris01.id)
        buttonIdsBoris.add(activityHomeBinding!!.imageButtonBoris02.id)
        buttonIdsBoris.add(activityHomeBinding!!.imageButtonBoris03.id)
        buttonIdsBoris.add(activityHomeBinding!!.imageButtonBoris04.id)
        buttonIdsBoris.add(activityHomeBinding!!.imageButtonBoris05.id)
        buttonIdsBoris.add(activityHomeBinding!!.imageButtonBoris06.id)
        buttonIdsBoris.add(activityHomeBinding!!.imageButtonBoris07.id)
        buttonIdsBoris.add(activityHomeBinding!!.imageButtonBoris08.id)
        buttonIdsBoris.add(activityHomeBinding!!.imageButtonBoris09.id)
        buttonIdsBoris.add(activityHomeBinding!!.imageButtonBoris10.id)
        registerClickListenersForButtonIds(buttonIdsBoris, ActivityBoris::class.java)
        selectedButtonIdBoris = activityHomeBinding!!.imageButtonBoris00.id
    }

    private fun registerButtonLiam() {
        buttonIdsLiam.add(activityHomeBinding!!.imageButtonLiam00.id)
        buttonIdsLiam.add(activityHomeBinding!!.imageButtonLiam01.id)
        buttonIdsLiam.add(activityHomeBinding!!.imageButtonLiam02.id)
        buttonIdsLiam.add(activityHomeBinding!!.imageButtonLiam03.id)
        buttonIdsLiam.add(activityHomeBinding!!.imageButtonLiam04.id)
        buttonIdsLiam.add(activityHomeBinding!!.imageButtonLiam05.id)
        registerClickListenersForButtonIds(buttonIdsLiam, ActivityLiam::class.java)
        selectedButtonIdLiam = activityHomeBinding!!.imageButtonLiam00.id
    }

    private fun registerButtonDavid() {
        buttonIdsDavid.add(activityHomeBinding!!.imageButtonDavid00.id)
        buttonIdsDavid.add(activityHomeBinding!!.imageButtonDavid01.id)
        buttonIdsDavid.add(activityHomeBinding!!.imageButtonDavid02.id)
        buttonIdsDavid.add(activityHomeBinding!!.imageButtonDavid03.id)
        registerClickListenersForButtonIds(buttonIdsDavid, ActivityDavid::class.java)
        selectedButtonIdDavid = activityHomeBinding!!.imageButtonDavid00.id
    }

    private fun registerButtonTheresa() {
        buttonIdsTheresa.add(activityHomeBinding!!.imageButtonTheresa00.id)
        buttonIdsTheresa.add(activityHomeBinding!!.imageButtonTheresa01.id)
        buttonIdsTheresa.add(activityHomeBinding!!.imageButtonTheresa02.id)
        buttonIdsTheresa.add(activityHomeBinding!!.imageButtonTheresa03.id)
        buttonIdsTheresa.add(activityHomeBinding!!.imageButtonTheresa04.id)
        registerClickListenersForButtonIds(buttonIdsTheresa, ActivityTheresa::class.java)
        selectedButtonIdTheresa = activityHomeBinding!!.imageButtonTheresa00.id
    }

    private fun registerButtonJacob() {
        buttonIdsJacob.add(activityHomeBinding!!.imageButtonMogg00.id)
        buttonIdsJacob.add(activityHomeBinding!!.imageButtonMogg01.id)
        buttonIdsJacob.add(activityHomeBinding!!.imageButtonMogg02.id)
        registerClickListenersForButtonIds(buttonIdsJacob, ActivityJacob::class.java)
        selectedButtonIdJacob = activityHomeBinding!!.imageButtonMogg00.id
    }

    private fun registerClickListenerWikipedia() {
        activityHomeBinding!!.textViewNameBoris.setOnClickListener {
            startActivity(
                Intent(
                    Intent.ACTION_VIEW,
                    "https://en.wikipedia.org/wiki/Boris_Johnson".toUri(),
                ),
            )
        }
        activityHomeBinding!!.textViewNameLiam.setOnClickListener {
            startActivity(
                Intent(
                    Intent.ACTION_VIEW,
                    "https://en.wikipedia.org/wiki/Liam_Fox".toUri(),
                ),
            )
        }
        activityHomeBinding!!.textViewNameDavid.setOnClickListener {
            startActivity(
                Intent(
                    Intent.ACTION_VIEW,
                    "https://en.wikipedia.org/wiki/David_Davis_(British_politician)".toUri(),
                ),
            )
        }
        activityHomeBinding!!.textViewNameTheresa.setOnClickListener {
            startActivity(
                Intent(
                    Intent.ACTION_VIEW,
                    "https://en.wikipedia.org/wiki/Theresa_May".toUri(),
                ),
            )
        }
        activityHomeBinding!!.textViewNameJacob.setOnClickListener {
            startActivity(
                Intent(
                    Intent.ACTION_VIEW,
                    "https://en.wikipedia.org/wiki/Jacob_Rees-Mogg".toUri(),
                ),
            )
        }
    }

    private fun registerClickListenerFooter() {
        val githubUrl = "https://github.com/jameshnsears/brexitsoundboard"
        activityHomeBinding!!.textViewVersion.setOnClickListener {
            startActivity(
                Intent(
                    Intent.ACTION_VIEW,
                    githubUrl.toUri(),
                ),
            )
        }
        activityHomeBinding!!.githubLogo.setOnClickListener {
            startActivity(
                Intent(
                    Intent.ACTION_VIEW,
                    githubUrl.toUri(),
                ),
            )
        }
    }

    private fun registerClickListenersForButtonIds(
        buttonIds: List<Int>,
        activity: Class<*>,
    ) {
        for (buttonId in buttonIds) {
            registerClickListenerForButtonId(buttonId, activity)
        }
    }

    private fun registerClickListenerForButtonId(
        imageButtonViewId: Int,
        activityClass: Class<*>?,
    ) {
        findViewById<View>(imageButtonViewId).setOnClickListener { view: View ->
            imageButtonClickedOn = findViewById(imageButtonViewId)
            val imageButton = imageButtonClickedOn
            if (imageButton != null) {
                auditEvent(AuditEventHelper.Event.PERSON, imageButton.contentDescription.toString())
            }
            view.context.startActivity(Intent(view.context, activityClass))
        }
    }

    private fun setButtonImage(selectedImageButton: ImageButton) {
        when (determineButtonType(selectedImageButton)) {
            ButtonType.BORIS ->
                selectedButtonIdBoris =
                    setNextButtonImage(selectedImageButton, buttonIdsBoris)

            ButtonType.LIAM ->
                selectedButtonIdLiam =
                    setNextButtonImage(selectedImageButton, buttonIdsLiam)

            ButtonType.DAVID ->
                selectedButtonIdDavid =
                    setNextButtonImage(selectedImageButton, buttonIdsDavid)

            ButtonType.THERESA ->
                selectedButtonIdTheresa =
                    setNextButtonImage(selectedImageButton, buttonIdsTheresa)

            ButtonType.JACOB ->
                selectedButtonIdJacob =
                    setNextButtonImage(selectedImageButton, buttonIdsJacob)
        }
    }

    private fun determineButtonType(imageButton: ImageButton): ButtonType {
        val buttonType: ButtonType =
            when {
                buttonIdsBoris.contains(imageButton.id) -> {
                    ButtonType.BORIS
                }

                buttonIdsLiam.contains(imageButton.id) -> {
                    ButtonType.LIAM
                }

                buttonIdsDavid.contains(imageButton.id) -> {
                    ButtonType.DAVID
                }

                buttonIdsTheresa.contains(imageButton.id) -> {
                    ButtonType.THERESA
                }

                else -> {
                    ButtonType.JACOB
                }
            }

        Timber.d(buttonType.toString())
        return buttonType
    }

    fun setNextButtonImage(
        selectedImageButton: ImageButton,
        buttonIds: List<Int>,
    ): Int {
        for (buttonId in buttonIds) {
            findViewById<View>(buttonId).visibility = View.GONE
        }
        var nextActiveImageButtonIdIndex = 0
        if (buttonIds.indexOf(selectedImageButton.id) < buttonIds.size - 1) {
            nextActiveImageButtonIdIndex = 1 + buttonIds.indexOf(selectedImageButton.id)
        }
        val view = findViewById<View>(buttonIds[nextActiveImageButtonIdIndex])
        view.visibility = View.VISIBLE
        return view.id
    }

    private fun restoreButtonImage(
        selectedButtonId: Int,
        buttonIds: List<Int>,
    ) {
        if (buttonIds.contains(selectedButtonId)) {
            for (buttonId in buttonIds) {
                findViewById<View>(buttonId).visibility = View.GONE
            }

            findViewById<View>(selectedButtonId).visibility = View.VISIBLE
        }
    }

    private fun sharedPreferencesSave() {
        getSharedPreferences(this).edit {
            putInt(SharedPreferencesHelper.SELECTED_BUTTONID_BORIS, selectedButtonIdBoris)
            Timber.d(String.format(Locale.UK, "selectedButtonIdBoris=%d", selectedButtonIdBoris))

            putInt(SharedPreferencesHelper.SELECTED_BUTTONID_LIAM, selectedButtonIdLiam)
            Timber.d(String.format(Locale.UK, "selectedButtonIdLiam=%d", selectedButtonIdLiam))

            putInt(SharedPreferencesHelper.SELECTED_BUTTONID_DAVID, selectedButtonIdDavid)
            Timber.d(String.format(Locale.UK, "selectedButtonIdDavid=%d", selectedButtonIdDavid))

            putInt(
                SharedPreferencesHelper.SELECTED_BUTTONID_THERESA,
                selectedButtonIdTheresa,
            )
            Timber.d(
                String.format(
                    Locale.UK,
                    "selectedButtonIdTheresa=%d",
                    selectedButtonIdTheresa,
                ),
            )

            putInt(SharedPreferencesHelper.SELECTED_BUTTONID_JACOB, selectedButtonIdJacob)
            Timber.d(String.format(Locale.UK, "selectedButtonIdJacob=%d", selectedButtonIdJacob))
        }
    }

    private fun sharedPreferencesRestore() {
        val sharedPreferences = getSharedPreferences(this)

        selectedButtonIdBoris =
            sharedPreferences.getInt(
                SharedPreferencesHelper.SELECTED_BUTTONID_BORIS,
                activityHomeBinding!!.imageButtonBoris00.id,
            )
        restoreButtonImage(selectedButtonIdBoris, buttonIdsBoris)

        selectedButtonIdLiam =
            sharedPreferences.getInt(
                SharedPreferencesHelper.SELECTED_BUTTONID_LIAM,
                activityHomeBinding!!.imageButtonLiam00.id,
            )
        restoreButtonImage(selectedButtonIdLiam, buttonIdsLiam)

        selectedButtonIdDavid =
            sharedPreferences.getInt(
                SharedPreferencesHelper.SELECTED_BUTTONID_DAVID,
                activityHomeBinding!!.imageButtonDavid00.id,
            )
        restoreButtonImage(selectedButtonIdDavid, buttonIdsDavid)

        selectedButtonIdTheresa =
            sharedPreferences.getInt(
                SharedPreferencesHelper.SELECTED_BUTTONID_THERESA,
                activityHomeBinding!!.imageButtonTheresa00.id,
            )
        restoreButtonImage(selectedButtonIdTheresa, buttonIdsTheresa)

        selectedButtonIdJacob =
            sharedPreferences.getInt(
                SharedPreferencesHelper.SELECTED_BUTTONID_JACOB,
                activityHomeBinding!!.imageButtonMogg00.id,
            )
        restoreButtonImage(selectedButtonIdJacob, buttonIdsJacob)
    }
}
