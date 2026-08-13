package com.vocablend.myapplication.counter

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel

object CounterScreenTestTags {
    const val COUNT_TEXT = "counter_count_text"
    const val INCREMENT_BUTTON = "counter_increment_button"
}

@Composable
fun CounterScreen(
    modifier: Modifier = Modifier,
    viewModel: CounterViewModel = viewModel(factory = CounterViewModel.Factory)
) {
    val state by viewModel.state.collectAsState()
    CounterScreenContent(
        state = state,
        onEvent = viewModel::onEvent,
        modifier = modifier
    )
}

@Composable
internal fun CounterScreenContent(
    state: CounterContract.State,
    onEvent: (CounterContract.Event) -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "Count: ${state.count}",
            modifier = Modifier.testTag(CounterScreenTestTags.COUNT_TEXT)
        )
        Button(
            onClick = { onEvent(CounterContract.Event.Increment) },
            modifier = Modifier.testTag(CounterScreenTestTags.INCREMENT_BUTTON)
        ) {
            Text(text = "Increment")
        }
    }
}
