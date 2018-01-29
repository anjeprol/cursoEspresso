/*
 *      File: MainActivityEspressoTest.java
 *    Author: Antonio Prado <antonio.prado@amk-technologies.com>
 *      Date: Jan 30, 2018
 * Copyright: AMK Technologies, S.A. de C.V. 2017
 */
package com.espresso.curso.myapplication;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

/**
 * Espresso course.
 *
 * <p>This is the main class to run the test project.
 * The propose of this project is to help any new member get knowledge creating functional testing
 * working with Espresso.</p>
 *
 * @author Antonio Prado &lt;antonio.prado@amk-technologies.com&gt;
 * @version 1.0.0
 * @since 1.0.0
 */

@RunWith(AndroidJUnit4.class)
public class MainActivityEspressoTest {

    @Rule
    public ActivityTestRule<MainActivity> mainActivity =
            new ActivityTestRule<>(MainActivity.class);

    @Test
    public void verifyTextChangeWork() {
        /**
         * Adding the first input data.
         */
        onView(withId(R.id.text))
                .perform(typeText("TEST"), closeSoftKeyboard());
        /**
         * Then click the button, change text.
         */
        onView(withId(R.id.changeTextView)).perform(click());
        /**
         * Checking the input at textView below change textView.
         */
        onView(withId(R.id.textView)).check(matches(withText("TEST")));

        /**
         * Then click change activity.
         */
        onView(withId(R.id.changeActivity)).perform(click());

        /**
         * Verify the data at activity 2.
         */
        onView(withId(R.id.text2))
                .check(matches(withText("TEST")));

    }
}
