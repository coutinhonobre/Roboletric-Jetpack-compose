package com.vocablend.myapplication

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.vocablend.myapplication.ui.theme.MyApplicationTheme

@Preview(showBackground = true)
@Composable
private fun GreetingPreview() {
    MyApplicationTheme {
        Greeting("Android")
    }
}
