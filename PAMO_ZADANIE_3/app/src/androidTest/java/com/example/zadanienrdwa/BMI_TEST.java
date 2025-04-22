package com.example.zadanienrdwa;


import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withClassName;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withParent;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.is;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;

import androidx.test.espresso.ViewInteraction;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.filters.LargeTest;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;
import org.hamcrest.core.IsInstanceOf;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

@LargeTest
@RunWith(AndroidJUnit4.class)
public class BMI_TEST {

    @Rule
    public ActivityScenarioRule<MainActivity> mActivityScenarioRule =
            new ActivityScenarioRule<>(MainActivity.class);

    @Test
    public void bMI_TEST() {
        ViewInteraction materialButton = onView(
                allOf(withId(R.id.button_calculate_bmi), withText("Wskaźnik masy ciała"),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("androidx.core.widget.NestedScrollView")),
                                        0),
                                1),
                        isDisplayed()));
        materialButton.perform(click());

        ViewInteraction materialButton2 = onView(
                allOf(withId(R.id.buttonDecreaseWeight), withText("-"),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("androidx.core.widget.NestedScrollView")),
                                        0),
                                1),
                        isDisplayed()));
        materialButton2.perform(click());

        ViewInteraction materialButton3 = onView(
                allOf(withId(R.id.buttonDecreaseWeight), withText("-"),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("androidx.core.widget.NestedScrollView")),
                                        0),
                                1),
                        isDisplayed()));
        materialButton3.perform(click());

        ViewInteraction materialButton4 = onView(
                allOf(withId(R.id.buttonDecreaseWeight), withText("-"),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("androidx.core.widget.NestedScrollView")),
                                        0),
                                1),
                        isDisplayed()));
        materialButton4.perform(click());

        ViewInteraction materialButton5 = onView(
                allOf(withId(R.id.buttonDecreaseWeight), withText("-"),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("androidx.core.widget.NestedScrollView")),
                                        0),
                                1),
                        isDisplayed()));
        materialButton5.perform(click());

        ViewInteraction materialButton6 = onView(
                allOf(withId(R.id.buttonDecreaseHeight), withText("-"),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("androidx.core.widget.NestedScrollView")),
                                        0),
                                5),
                        isDisplayed()));
        materialButton6.perform(click());

        ViewInteraction materialButton7 = onView(
                allOf(withId(R.id.buttonDecreaseHeight), withText("-"),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("androidx.core.widget.NestedScrollView")),
                                        0),
                                5),
                        isDisplayed()));
        materialButton7.perform(click());

        ViewInteraction materialButton8 = onView(
                allOf(withId(R.id.buttonDecreaseHeight), withText("-"),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("androidx.core.widget.NestedScrollView")),
                                        0),
                                5),
                        isDisplayed()));
        materialButton8.perform(click());

        ViewInteraction materialButton9 = onView(
                allOf(withId(R.id.buttonIncreaseHeight), withText("+"),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("androidx.core.widget.NestedScrollView")),
                                        0),
                                7),
                        isDisplayed()));
        materialButton9.perform(click());

        ViewInteraction materialButton10 = onView(
                allOf(withId(R.id.buttonIncreaseHeight), withText("+"),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("androidx.core.widget.NestedScrollView")),
                                        0),
                                7),
                        isDisplayed()));
        materialButton10.perform(click());

        ViewInteraction materialButton11 = onView(
                allOf(withId(R.id.buttonIncreaseHeight), withText("+"),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("androidx.core.widget.NestedScrollView")),
                                        0),
                                7),
                        isDisplayed()));
        materialButton11.perform(click());

        ViewInteraction materialButton12 = onView(
                allOf(withId(R.id.buttonIncreaseHeight), withText("+"),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("androidx.core.widget.NestedScrollView")),
                                        0),
                                7),
                        isDisplayed()));
        materialButton12.perform(click());

        ViewInteraction materialButton13 = onView(
                allOf(withId(R.id.buttonIncreaseHeight), withText("+"),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("androidx.core.widget.NestedScrollView")),
                                        0),
                                7),
                        isDisplayed()));
        materialButton13.perform(click());

        ViewInteraction materialButton14 = onView(
                allOf(withId(R.id.buttonIncreaseHeight), withText("+"),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("androidx.core.widget.NestedScrollView")),
                                        0),
                                7),
                        isDisplayed()));
        materialButton14.perform(click());

        ViewInteraction materialButton15 = onView(
                allOf(withId(R.id.buttonIncreaseHeight), withText("+"),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("androidx.core.widget.NestedScrollView")),
                                        0),
                                7),
                        isDisplayed()));
        materialButton15.perform(click());

        ViewInteraction materialButton16 = onView(
                allOf(withId(R.id.buttonIncreaseHeight), withText("+"),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("androidx.core.widget.NestedScrollView")),
                                        0),
                                7),
                        isDisplayed()));
        materialButton16.perform(click());

        ViewInteraction materialButton17 = onView(
                allOf(withId(R.id.buttonIncreaseHeight), withText("+"),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("androidx.core.widget.NestedScrollView")),
                                        0),
                                7),
                        isDisplayed()));
        materialButton17.perform(click());

        ViewInteraction materialButton18 = onView(
                allOf(withId(R.id.button_calculate), withText("Oblicz swoje BMI"),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("androidx.core.widget.NestedScrollView")),
                                        0),
                                8),
                        isDisplayed()));
        materialButton18.perform(click());

        ViewInteraction textView = onView(
                allOf(withId(R.id.bmi_result_text), withText("Twoje BMI: 24.54 - Waga prawidłowa"),
                        withParent(withParent(IsInstanceOf.<View>instanceOf(android.widget.ScrollView.class))),
                        isDisplayed()));
        textView.check(matches(withText("Twoje BMI: 24.54 - Waga prawidłowa")));
    }

    private static Matcher<View> childAtPosition(
            final Matcher<View> parentMatcher, final int position) {

        return new TypeSafeMatcher<View>() {
            @Override
            public void describeTo(Description description) {
                description.appendText("Child at position " + position + " in parent ");
                parentMatcher.describeTo(description);
            }

            @Override
            public boolean matchesSafely(View view) {
                ViewParent parent = view.getParent();
                return parent instanceof ViewGroup && parentMatcher.matches(parent)
                        && view.equals(((ViewGroup) parent).getChildAt(position));
            }
        };
    }
}
