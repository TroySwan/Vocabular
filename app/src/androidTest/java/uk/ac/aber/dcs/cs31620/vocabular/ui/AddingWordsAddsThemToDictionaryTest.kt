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
class AddingWordsAddsThemToDictionaryTest {

    @Rule
    @JvmField
    var mActivityTestRule = ActivityTestRule(MainActivity::class.java)

    @Test
    fun addingWordsAddsThemToDictionaryTest() {
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

        val bottomNavigationItemView = onView(
            allOf(
                withId(R.id.navigation_dictionary), withContentDescription("Dictionary"),
                childAtPosition(
                    childAtPosition(
                        withId(R.id.nav_view),
                        0
                    ),
                    1
                ),
                isDisplayed()
            )
        )
        bottomNavigationItemView.perform(click())

        val floatingActionButton = onView(
            allOf(
                withId(R.id.floatingActionButton),
                withContentDescription("Add dictionary item button"),
                childAtPosition(
                    childAtPosition(
                        withId(R.id.nav_host_fragment),
                        0
                    ),
                    1
                ),
                isDisplayed()
            )
        )
        floatingActionButton.perform(click())

        val appCompatEditText3 = onView(
            allOf(
                withId(R.id.WordInLearningLanguageField),
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
        appCompatEditText3.perform(replaceText("oui"), closeSoftKeyboard())

        val appCompatEditText4 = onView(
            allOf(
                withId(R.id.MeaningNativeLanguageField),
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
        appCompatEditText4.perform(replaceText("yes"), closeSoftKeyboard())

        val floatingActionButton2 = onView(
            allOf(
                withId(R.id.AddDictionaryItem),
                withContentDescription("Add dictionary item button"),
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
        floatingActionButton2.perform(click())

        val textView = onView(
            allOf(
                withId(R.id.WordTextView),
                withText("oui"),
                withContentDescription("Word in learning language"),
                withParent(withParent(withId(R.id.DictionaryItemCard))),
                isDisplayed()
            )
        )
        textView.check(matches(withText("oui")))

        val textView2 = onView(
            allOf(
                withId(R.id.MeaningTextView),
                withText("yes"),
                withContentDescription("Meaning in native language"),
                withParent(withParent(withId(R.id.DictionaryItemCard))),
                isDisplayed()
            )
        )
        textView2.check(matches(withText("yes")))

        val textView3 = onView(
            allOf(
                withId(R.id.MeaningTextView),
                withText("yes"),
                withContentDescription("Meaning in native language"),
                withParent(withParent(withId(R.id.DictionaryItemCard))),
                isDisplayed()
            )
        )
        textView3.check(matches(withText("yes")))

        val bottomNavigationItemView2 = onView(
            allOf(
                withId(R.id.navigation_tests), withContentDescription("Tests"),
                childAtPosition(
                    childAtPosition(
                        withId(R.id.nav_view),
                        0
                    ),
                    2
                ),
                isDisplayed()
            )
        )
        bottomNavigationItemView2.perform(click())

        val bottomNavigationItemView3 = onView(
            allOf(
                withId(R.id.navigation_dictionary), withContentDescription("Dictionary"),
                childAtPosition(
                    childAtPosition(
                        withId(R.id.nav_view),
                        0
                    ),
                    1
                ),
                isDisplayed()
            )
        )
        bottomNavigationItemView3.perform(click())

        val floatingActionButton3 = onView(
            allOf(
                withId(R.id.floatingActionButton),
                withContentDescription("Add dictionary item button"),
                childAtPosition(
                    childAtPosition(
                        withId(R.id.nav_host_fragment),
                        0
                    ),
                    1
                ),
                isDisplayed()
            )
        )
        floatingActionButton3.perform(click())

        val appCompatEditText5 = onView(
            allOf(
                withId(R.id.WordInLearningLanguageField),
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
        appCompatEditText5.perform(replaceText("non"), closeSoftKeyboard())

        val appCompatEditText6 = onView(
            allOf(
                withId(R.id.MeaningNativeLanguageField),
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
        appCompatEditText6.perform(replaceText("no"), closeSoftKeyboard())

        val floatingActionButton4 = onView(
            allOf(
                withId(R.id.AddDictionaryItem),
                withContentDescription("Add dictionary item button"),
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
        floatingActionButton4.perform(click())

        val frameLayout = onView(
            allOf(
                withId(R.id.navigation_dictionary), withContentDescription("Dictionary"),
                withParent(withParent(withId(R.id.nav_view))),
                isDisplayed()
            )
        )
        frameLayout.check(matches(isDisplayed()))
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
