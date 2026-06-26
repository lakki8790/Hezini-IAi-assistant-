package com.hezini.assistant.ui.auth

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.hezini.assistant.R
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@HiltAndroidTest
@RunWith(AndroidJUnit4::class)
class AuthFlowTest {

    @get:Rule(order = 0)
    var hiltRule = HiltAndroidRule(this)

    @get:Rule(order = 1)
    var activityRule = ActivityScenarioRule(AuthActivity::class.java)

    @Before
    fun init() {
        hiltRule.inject()
    }

    @Test
    fun loginFormValidation_emptyEmailShowsError() {
        // Navigate to Login from Welcome
        onView(withId(R.id.btnEmail)).perform(click())

        // Click Sign In with empty fields
        onView(withId(R.id.btnLogin)).perform(click())

        // Verify Snackbar or error message (implementation dependent)
        onView(withText("Please fill all fields")).check(matches(isDisplayed()))
    }
}
