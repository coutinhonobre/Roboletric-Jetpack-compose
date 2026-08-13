package com.vocablend.myapplication.counter

import androidx.compose.ui.test.assertTextEquals
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.performClick
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config

@RunWith(RobolectricTestRunner::class)
@Config(sdk = [34])
class CounterScreenTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun `screen starts at zero and increments when button is clicked`() {
        // CounterScreen() resolves its own ViewModel through CounterViewModel.Factory,
        // exercising the same factory (no DI framework) path used in production.
        composeTestRule.setContent {
            CounterScreen()
        }

        composeTestRule.onNodeWithTag(CounterScreenTestTags.COUNT_TEXT)
            .assertTextEquals("Count: 0")

        composeTestRule.onNodeWithTag(CounterScreenTestTags.INCREMENT_BUTTON)
            .performClick()

        composeTestRule.onNodeWithTag(CounterScreenTestTags.COUNT_TEXT)
            .assertTextEquals("Count: 1")

        composeTestRule.onNodeWithTag(CounterScreenTestTags.INCREMENT_BUTTON)
            .performClick()

        composeTestRule.onNodeWithTag(CounterScreenTestTags.COUNT_TEXT)
            .assertTextEquals("Count: 2")
    }

    @Test
    fun `content reflects the state it is given`() {
        composeTestRule.setContent {
            CounterScreenContent(
                state = CounterContract.State(count = 42),
                onEvent = {}
            )
        }

        composeTestRule.onNodeWithTag(CounterScreenTestTags.COUNT_TEXT)
            .assertTextEquals("Count: 42")
    }
}
