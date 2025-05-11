package com.example.zadanienrdwa;


import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.replaceText;
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
public class MainActivityTest2 {
    //TESTY TWORZONE ZA POMOCĄ RECORDINGS - POKAZANE NA WYKŁĄDZIE
    @Rule
    public ActivityScenarioRule<MainActivity> mActivityScenarioRule =
            new ActivityScenarioRule<>(MainActivity.class);

    @Test
    public void mainActivityTest2() {
        ViewInteraction materialButton = onView(
                allOf(withId(R.id.button_calculate_kcal), withText("Zapotrzebowanie kaloryczne"),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("androidx.core.widget.NestedScrollView")),
                                        0),
                                2),
                        isDisplayed()));
        materialButton.perform(click());

        ViewInteraction materialButton2 = onView(
                allOf(withId(R.id.gender_male), withText("Mężczyzna"),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("androidx.core.widget.NestedScrollView")),
                                        0),
                                0),
                        isDisplayed()));
        materialButton2.perform(click());

        ViewInteraction appCompatEditText = onView(
                allOf(withId(R.id.age_input),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("androidx.core.widget.NestedScrollView")),
                                        0),
                                3),
                        isDisplayed()));
        appCompatEditText.perform(replaceText("50"), closeSoftKeyboard());

        ViewInteraction appCompatEditText2 = onView(
                allOf(withId(R.id.weight_input),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("androidx.core.widget.NestedScrollView")),
                                        0),
                                5),
                        isDisplayed()));
        appCompatEditText2.perform(replaceText("80"), closeSoftKeyboard());

        ViewInteraction appCompatEditText3 = onView(
                allOf(withId(R.id.height_input),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("androidx.core.widget.NestedScrollView")),
                                        0),
                                7),
                        isDisplayed()));
        appCompatEditText3.perform(replaceText("180"), closeSoftKeyboard());

        ViewInteraction materialButton3 = onView(
                allOf(withId(R.id.activity_medium), withText("Średnia"),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("androidx.core.widget.NestedScrollView")),
                                        0),
                                10),
                        isDisplayed()));
        materialButton3.perform(click());

        ViewInteraction materialButton4 = onView(
                allOf(withId(R.id.calculate_button), withText("Zapotrzebowanie kaloryczne"),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("androidx.core.widget.NestedScrollView")),
                                        0),
                                12),
                        isDisplayed()));
        materialButton4.perform(click());

        ViewInteraction textView = onView(
                allOf(withId(R.id.calorie_result_text), withText("Twoje dzienne zapotrzebowanie kaloryczne: 2697.14 kcal"),
                        withParent(withParent(IsInstanceOf.<View>instanceOf(android.widget.ScrollView.class))),
                        isDisplayed()));
        textView.check(matches(withText("Twoje dzienne zapotrzebowanie kaloryczne: 2697.14 kcal")));

        ViewInteraction textView2 = onView(
                allOf(withId(R.id.meal_suggestions), withText("Cięższe posiłki: Stek z ziemniakami, Makaron z mięsem mielonym."),
                        withParent(withParent(IsInstanceOf.<View>instanceOf(android.widget.ScrollView.class))),
                        isDisplayed()));
        textView2.check(matches(withText("Cięższe posiłki: Stek z ziemniakami, Makaron z mięsem mielonym.")));
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
