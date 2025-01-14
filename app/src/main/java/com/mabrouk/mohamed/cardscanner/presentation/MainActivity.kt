package com.mabrouk.mohamed.cardscanner.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import com.mabrouk.mohamed.cardscanner.presentation.theme.CardScanner_NewTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CardScanner_NewTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(
    showBackground = true,
    device = Devices.PIXEL,
    name = "test",
    showSystemUi = true
)

@Composable
fun GreetingPreview() {
    CardScanner_NewTheme {
        Greeting("Android")
    }
}



// Plan

// todo: fix app icon
/*
* Screens :
* (1) Scan
* (2) Operator
* (3) Dial
*
*
*
*
*
*
* possible addons:
* ارقام الاختصارات
* push notifications
* analytics
* crashlytics
*
* */