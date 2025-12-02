package com.gmail.denuelle42.denuboilerplate

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.gmail.denuelle42.denuboilerplate.ui.theme.DenuBoilerplateTheme
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(
    onFinished: () -> Unit
) {
    LaunchedEffect(Unit) {
        delay(1500)  // fake loading
        onFinished()
    }

    Box(modifier = Modifier.fillMaxSize()){
        Text(
            text = "SPLASHSCREEN",
            style = MaterialTheme.typography.displaySmall,
            modifier = Modifier.align(
                Alignment.Center
            )
        )
    }
}

@Preview
@Composable
private fun SplashScreenPreview() {
    DenuBoilerplateTheme {
        Surface(modifier = Modifier.background(color = MaterialTheme.colorScheme.surface).fillMaxSize()) {
            SplashScreen(){}
        }
    }
}