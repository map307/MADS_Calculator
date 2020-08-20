package com.mayurapps.madscalculator;

import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso
import androidx.test.espresso.Espresso.pressBack
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4ClassRunner::class)
public class LoginActivityTest {

    @Test
    fun testLoginActivity_inView() {
        val activityScenario = ActivityScenario.launch(LoginActivity::class.java)

        Espresso.onView(ViewMatchers.withId(R.id.nestedScrollView)).check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
    }

    @Test
    fun test_navLoginToRegAndBac() {

        val activityScenario = ActivityScenario.launch(LoginActivity::class.java)

        Espresso.onView(ViewMatchers.withId(R.id.textViewLinkRegister)).perform(ViewActions.click())

        Espresso.onView(ViewMatchers.withId(R.id.appCompatButtonRegister)).check(ViewAssertions.matches(ViewMatchers.isDisplayed()))

        pressBack()

        Espresso.onView(ViewMatchers.withId(R.id.textViewLinkRegister)).perform(ViewActions.click())
    }

}