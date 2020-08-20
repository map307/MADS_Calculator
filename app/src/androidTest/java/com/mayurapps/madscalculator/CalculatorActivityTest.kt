package com.mayurapps.madscalculator;

import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso
import androidx.test.espresso.Espresso.pressBack
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4ClassRunner::class)
class CalculatorActivityTest {
    @Test
    fun testActivity_inView() {
        val activityScenario = ActivityScenario.launch(CalculatorActivity::class.java)

        Espresso.onView(withId(R.id.txtScreen)).check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
    }

    // Visibility
    @Test
    fun testVisibility_btns() {
        val activityScenario = ActivityScenario.launch(CalculatorActivity::class.java)

        Espresso.onView(withId(R.id.historyBtn))
                .check(ViewAssertions.matches(ViewMatchers.isDisplayed())) // method 1

        Espresso.onView(withId(R.id.btnClear))
                .check(ViewAssertions.matches(ViewMatchers.withEffectiveVisibility(ViewMatchers.Visibility.VISIBLE))) // method 2

        Espresso.onView(withId(R.id.btn_equal))
                .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))

        Espresso.onView(withId(R.id.btn_add))
                .check(ViewAssertions.matches(ViewMatchers.withEffectiveVisibility(ViewMatchers.Visibility.VISIBLE)))

        Espresso.onView(withId(R.id.btn_divide))
                .check(ViewAssertions.matches(ViewMatchers.withEffectiveVisibility(ViewMatchers.Visibility.VISIBLE)))

        Espresso.onView(withId(R.id.btn_multiply))
                .check(ViewAssertions.matches(ViewMatchers.withEffectiveVisibility(ViewMatchers.Visibility.VISIBLE)))

        Espresso.onView(withId(R.id.btn_subtract))
                .check(ViewAssertions.matches(ViewMatchers.withEffectiveVisibility(ViewMatchers.Visibility.VISIBLE)))

    }


    @Test
    fun test_navActivity() {

        val activityScenario = ActivityScenario.launch(CalculatorActivity::class.java)

        Espresso.onView(withId(R.id.historyBtn)).perform(ViewActions.click())

        Espresso.onView(withId(R.id.history)).check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
    }

    @Test
    fun test_navActivityAndBack() {

        val activityScenario = ActivityScenario.launch(CalculatorActivity::class.java)

        Espresso.onView(withId(R.id.historyBtn)).perform(ViewActions.click())

        Espresso.onView(withId(R.id.history)).check(ViewAssertions.matches(ViewMatchers.isDisplayed()))

        pressBack()

        Espresso.onView(withId(R.id.calculator)).check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
    }

}