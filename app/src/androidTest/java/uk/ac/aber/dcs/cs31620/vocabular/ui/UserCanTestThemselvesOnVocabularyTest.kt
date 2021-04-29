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
class UserCanTestThemselvesOnVocabularyTest {

    @Rule
    @JvmField
    var mActivityTestRule = ActivityTestRule(MainActivity::class.java)

    @Test
    fun userCanTestThemselvesOnVocabularyTest() {
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
        appCompatEditText.perform(replaceText("French"), closeSoftKeyboard())

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
        appCompatEditText2.perform(replaceText("English"), closeSoftKeyboard())

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
        appCompatEditText5.perform(click())

        val appCompatEditText6 = onView(
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
        appCompatEditText6.perform(replaceText("non"), closeSoftKeyboard())

        val appCompatEditText7 = onView(
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
        appCompatEditText7.perform(replaceText("no"), closeSoftKeyboard())

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

        val floatingActionButton5 = onView(
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
        floatingActionButton5.perform(click())

        val appCompatEditText8 = onView(
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
        appCompatEditText8.perform(click())

        val appCompatEditText9 = onView(
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
        appCompatEditText9.perform(replaceText("un"), closeSoftKeyboard())

        val appCompatEditText10 = onView(
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
        appCompatEditText10.perform(replaceText("one"), closeSoftKeyboard())

        val floatingActionButton6 = onView(
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
        floatingActionButton6.perform(click())

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

        val cardView = onView(
            allOf(
                withId(R.id.includeSpellingTest),
                childAtPosition(
                    childAtPosition(
                        withId(R.id.nav_host_fragment),
                        0
                    ),
                    0
                ),
                isDisplayed()
            )
        )
        cardView.perform(click())

        val appCompatEditText11 = onView(
            allOf(
                withId(R.id.SubmissionField),
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
        appCompatEditText11.perform(replaceText("non"), closeSoftKeyboard())

        val textView = onView(
            allOf(
                withText("Spelling Test"),
                withParent(
                    allOf(
                        withId(R.id.action_bar),
                        withParent(withId(R.id.action_bar_container))
                    )
                ),
                isDisplayed()
            )
        )
        textView.check(matches(withText("Spelling Test")))

        val button = onView(
            allOf(
                withId(R.id.SubmitAnswerButton), withText("SUBMIT"),
                withParent(withParent(withId(R.id.nav_host_fragment))),
                isDisplayed()
            )
        )
        button.check(matches(isDisplayed()))

        val editText = onView(
            allOf(
                withId(R.id.SubmissionField), withText("non"),
                withParent(withParent(withId(R.id.nav_host_fragment))),
                isDisplayed()
            )
        )
        editText.check(matches(isDisplayed()))

        val textView2 = onView(
            allOf(
                withId(R.id.QuestionsLeftNumberTextView), withText("2"),
                withParent(withParent(withId(R.id.nav_host_fragment))),
                isDisplayed()
            )
        )
        textView2.check(matches(withText("2")))
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
