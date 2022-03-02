package com.everest.userinfo

import address
import android.app.Activity
import android.app.Instrumentation
import android.content.Intent
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.intent.Intents.intended
import androidx.test.espresso.intent.matcher.IntentMatchers.*
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import email
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import phone_number
import pin_code
import userName


/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class ExampleInstrumentedTest {

    @get:Rule
    var rule = ActivityScenarioRule(HomeActivity::class.java)



    @Test
    fun inputFieldTest() {
        //get all views
        onView(withId(R.id.user_name_id_test)).perform(typeText("wenkey"), closeSoftKeyboard())
        onView(withId(R.id.email_id_test)).perform(typeText("wenkey@gmail.com"), closeSoftKeyboard())
        onView(withId(R.id.phone_number_id_test)).perform(typeText("9198762111"), closeSoftKeyboard())
        onView(withId(R.id.pin_code_id_test)).perform(typeText("524132"), closeSoftKeyboard())
        onView(withId(R.id.address_id_test)).perform(typeText("18-462, mahesh colony, subbayagari petta, amalapuram, 564526 "), closeSoftKeyboard())


        //click the button
        onView(withId(R.id.validate_button)).perform(click())

        //check with textview
        onView(withId(R.id.name_id)).check(matches(withText("wenkey")))
        onView(withId(R.id.email_id)).check(matches(withText("wenkey@gmail.com")))
        onView(withId(R.id.phone_number_id)).check(matches(withText("9198762111")))
        onView(withId(R.id.pin_code_id)).check(matches(withText("524132")))
        onView(withId(R.id.address_id)).check(matches(withText("18-462, mahesh colony, subbayagari petta, amalapuram, 564526 ")))
    }

    @Test
    fun onClickValidateButtonCardIsVisible() {

        onView(withId(R.id.user_name_id_test)).perform(typeText("wenkey"), closeSoftKeyboard())
        onView(withId(R.id.email_id_test)).perform(typeText("wenkey@gmail.com"), closeSoftKeyboard())
        onView(withId(R.id.phone_number_id_test)).perform(typeText("9198762111"), closeSoftKeyboard())
        onView(withId(R.id.pin_code_id_test)).perform(typeText("524132"), closeSoftKeyboard())
        onView(withId(R.id.address_id_test)).perform(typeText("18-462, mahesh colony, subbayagari petta, amalapuram, 564526 "), closeSoftKeyboard())

        onView(withId(R.id.edit_form)).check(matches(isDisplayed()))

        onView(withId(R.id.validate_button)).perform(click())

        onView(withId(R.id.summery_card)).check(matches(isDisplayed()))

    }
    @Test
    fun onClickCancelButtonFormIsVisible() {

        onView(withId(R.id.user_name_id_test)).perform(typeText("wenkey"), closeSoftKeyboard())
        onView(withId(R.id.email_id_test)).perform(typeText("wenkey@gmail.com"), closeSoftKeyboard())
        onView(withId(R.id.phone_number_id_test)).perform(typeText("9198762111"), closeSoftKeyboard())
        onView(withId(R.id.pin_code_id_test)).perform(typeText("524132"), closeSoftKeyboard())
        onView(withId(R.id.address_id_test)).perform(typeText("18-462, mahesh colony, subbayagari petta, amalapuram, 564526 "), closeSoftKeyboard())


        onView(withId(R.id.validate_button)).perform(click())

        onView(withId(com.google.android.material.R.id.cancel_button)).perform(click())

        onView(withId(R.id.edit_form)).check(matches(isDisplayed()))


    }


    @Test
    fun intentTest() {
        onView(withId(R.id.user_name_id_test)).perform(typeText("wenkey"), closeSoftKeyboard())
        onView(withId(R.id.email_id_test)).perform(typeText("wenkey@gmail.com"), closeSoftKeyboard())
        onView(withId(R.id.phone_number_id_test)).perform(typeText("9198762111"), closeSoftKeyboard())
        onView(withId(R.id.pin_code_id_test)).perform(typeText("524132"), closeSoftKeyboard())
        onView(withId(R.id.address_id_test)).perform(typeText("18-462, mahesh colony, subbayagari petta, amalapuram, 564526 "), closeSoftKeyboard())


        onView(withId(R.id.validate_button)).perform(click())

        onView(withId(R.id.confirm_button)).perform(click())


        val resultData = Intent()
        resultData.putExtra(userName,"wenkey" )
        resultData.putExtra(email,"wenkey@gmail.com" )
        resultData.putExtra(phone_number, "9198762111")
        resultData.putExtra(pin_code, "524132")
        resultData.putExtra(address,"18-462, mahesh colony, subbayagari petta, amalapuram, 564526 " )
        Instrumentation.ActivityResult(Activity.RESULT_OK, resultData)



    }
}