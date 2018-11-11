package com.jmlb0003.randomcoapp.presentation.userlist

import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.action.ViewActions.click
import android.support.test.espresso.assertion.ViewAssertions.matches
import android.support.test.espresso.contrib.RecyclerViewActions
import android.support.test.espresso.matcher.ViewMatchers.isDisplayed
import android.support.test.espresso.matcher.ViewMatchers.withId
import android.support.test.rule.ActivityTestRule
import android.support.test.runner.AndroidJUnit4
import com.jmlb0003.randomcoapp.R
import com.jmlb0003.randomcoapp.presentation.userlist.adapter.UserViewHolder
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class MainActivityTest {

    @get:Rule
    var testRule: ActivityTestRule<MainActivity> = ActivityTestRule(MainActivity::class.java)

    //TODO Implement Idling resource instead of wait

    @Test
    fun showUserDetailsWhenClickAnUser() {
        Thread.sleep(2000)

        onView(withId(R.id.user_list_view))
            .perform(RecyclerViewActions.actionOnItemAtPosition<UserViewHolder>(0, click()))


        Thread.sleep(2000)

    }
}