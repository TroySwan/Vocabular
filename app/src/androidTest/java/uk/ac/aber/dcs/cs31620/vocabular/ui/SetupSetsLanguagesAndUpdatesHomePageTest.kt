package uk.ac.aber.dcs.cs31620.vocabular.ui


import android.view.View
import android.view.ViewGroup
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.filters.LargeTest
import androidx.test.rule.ActivityTestRule
import androidx.test.runner.AndroidJUnit4
import org.hamcrest.Description
import org.hamcrest.Matcher
import org.hamcrest.Matchers.allOf
import org.hamcrest.TypeSafeMatcher
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import uk.ac.aber.dcs.cs31620.vocabular.MainActivity
import uk.ac.aber.dcs.cs31620.vocabular.R

@LargeTest
@RunWith(AndroidJUnit4::class)
class SetupSetsLanguagesAndUpdatesHomePageTest {

    @Rule
    @JvmField
    var mActivityTestRule = ActivityTestRule(MainActivity::class.java)

    @Test
    fun setupSetsLanguagesAndUpdatesHomePageTest() {
        val appCompatEditText = onView(
            allOf(
                withId(R.id.LearningLanguageField),
                childAtPosition(
                    childAtPosition(
                        withId(R.id.nav_host_fragment),
                        0
                    ),
                    2
                ),
                isDisplayed()
            )
        )
        appCompatEditText.perform(replaceText("french"), closeSoftKeyboard())

        val appCompatEditText2 = onView(
            allOf(
                withId(R.id.NativeLanguageField),
                childAtPosition(
                    childAtPosition(
                        withId(R.id.nav_host_fragment),
                        0
                    ),
                    4
                ),
                isDisplayed()
            )
        )
        appCompatEditText2.perform(replaceText("english"), closeSoftKeyboard())

        val appCompatEditText3 = onView(
            allOf(
                withId(R.id.NativeLanguageField), withText("english"),
                childAtPosition(
                    childAtPosition(
                        withId(R.id.nav_host_fragment),
                        0
                    ),
                    4
                ),
                isDisplayed()
            )
        )
        appCompatEditText3.perform(pressImeActionButton())

        val materialButton = onView(
            allOf(
                withId(R.id.button), withText("Continue"),
                childAtPosition(
                    childAtPosition(
                        withId(R.id.nav_host_fragment),
                        0
                    ),
                    5
                ),
                isDisplayed()
            )
        )
        materialButton.perform(click())

        val textView = onView(
            allOf(
                withId(R.id.LearningLanguageTextView), withText("French"),
                withParent(withParent(withId(R.id.LanguagesCard))),
                isDisplayed()
            )
        )
        textView.check(matches(withText("French")))

        val textView2 = onView(
            allOf(
                withId(R.id.NativeLanguageTextView), withText("English"),
                withParent(withParent(withId(R.id.LanguagesCard))),
                isDisplayed()
            )
        )
        textView2.check(matches(withText("English")))

        val frameLayout = onView(
            allOf(
                withId(R.id.nav_host_fragment),
                withParent(
                    allOf(
                        withId(R.id.coordinator),
                        withParent(withId(R.id.drawer_layout))
                    )
                ),
                isDisplayed()
            )
        )
        frameLayout.check(matches(isDisplayed()))

        val frameLayout2 = onView(
            allOf(
                withId(R.id.ChangeLanguagesCard),
                withParent(withParent(withId(R.id.nav_host_fragment))),
                isDisplayed()
            )
        )
        frameLayout2.check(matches(isDisplayed()))
    }

    private fun childAtPosition(
        parentMatcher: Matcher<View>, position: Int
    ): Matcher<View> {

        return object : TypeSafeMatcher<View>() {
            override fun describeTo(description: Description) {
                description.appendText("Child at position $position in parent ")
                parentMatcher.describeTo(description)
            }

            public override fun matchesSafely(view: View): Boolean {
                val parent = view.parent
                return parent is ViewGroup && parentMatcher.matches(parent)
                        && view == parent.getChildAt(position)
            }
        }
    }
}
