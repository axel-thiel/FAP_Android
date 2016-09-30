package com.findactivitypartner.damienaxel.findactivitypartner_app;


import android.support.test.espresso.ViewInteraction;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.test.suitebuilder.annotation.LargeTest;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;
import org.hamcrest.core.IsInstanceOf;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onData;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.replaceText;
import static android.support.test.espresso.action.ViewActions.scrollTo;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;

@LargeTest
@RunWith(AndroidJUnit4.class)
public class ResearchActionTest {

    @Rule
    public ActivityTestRule<MainActivity> mActivityTestRule = new ActivityTestRule<>(MainActivity.class);

    @Test
    public void researchActionTest() {
        ViewInteraction editText = onView(
                allOf(withId(R.id.edit_text_login), isDisplayed()));
        editText.perform(replaceText("TestUser1"), closeSoftKeyboard());

        ViewInteraction editText2 = onView(
                allOf(withId(R.id.edit_text_password), isDisplayed()));
        editText2.perform(replaceText("testuser1"), closeSoftKeyboard());

        ViewInteraction button = onView(
                allOf(withId(R.id.button_login), withText(" Connexion "), isDisplayed()));
        button.perform(click());

        ViewInteraction linearLayout = onData(withId(R.id.user_card_list))
                .inAdapterView(withId(R.layout.adapter_detail_fiche_user))
                .atPosition(0).perform(click());

        ViewInteraction relativeLayout = onView(
                allOf(withId(R.id.relativeLayoutResultActivity),
                        childAtPosition(
                                allOf(withId(android.R.id.content),
                                        childAtPosition(
                                                IsInstanceOf.<View>instanceOf(android.widget.LinearLayout.class),
                                                0)),
                                0),
                        isDisplayed()));
        relativeLayout.check(matches(isDisplayed()));
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
