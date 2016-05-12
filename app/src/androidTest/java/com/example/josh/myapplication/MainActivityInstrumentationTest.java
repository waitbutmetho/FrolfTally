package com.example.josh.myapplication;

import android.support.test.rule.ActivityTestRule;

import com.example.josh.myapplication.ui.MainActivity;

import org.junit.Rule;
import org.junit.Test;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

public class MainActivityInstrumentationTest {
    @Rule
    public ActivityTestRule<MainActivity> activityTestRule =
            new ActivityTestRule<>(MainActivity.class);

    @Test
    public void nextHoleButtonChangesHole() {
        onView(withId(R.id.nextHoleBtn)).perform(click());
        onView(withId(R.id.currentHoleView)).check(matches
                (withText("Hole 2")));
    }
    @Test
    public void previousHoleButtonChangesHole() {
        onView(withId(R.id.previousHoleBtn)).perform(click());
        onView(withId(R.id.currentHoleView)).check(matches
                (withText("Hole 1")));
    }

    @Test
    public void homeButtonGoesToHomeActivity() {
        onView(withId(R.id.homeBtn)).perform(click());
        onView(withId(R.id.scoreTrackerBtn)).check(matches
                (withText("Score Tracker")));
    }
}
