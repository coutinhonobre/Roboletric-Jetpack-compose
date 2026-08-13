package com.vocablend.myapplication.counter

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview

@Preview(showBackground = true)
@Composable
private fun CounterScreenPreview() {
    CounterScreenContent(
        state = CounterContract.State(count = 3),
        onEvent = {}
    )
}
