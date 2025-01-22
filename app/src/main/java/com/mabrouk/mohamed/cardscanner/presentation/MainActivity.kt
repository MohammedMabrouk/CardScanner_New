package com.mabrouk.mohamed.cardscanner.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.mabrouk.mohamed.cardscanner.presentation.screens.OperatorScreen
import com.mabrouk.mohamed.cardscanner.presentation.screens.ScanResultScreen
import com.mabrouk.mohamed.cardscanner.presentation.screens.ScanScreen
import com.mabrouk.mohamed.cardscanner.presentation.screens.Screen
import com.mabrouk.mohamed.cardscanner.presentation.theme.CardScanner_NewTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CardScanner_NewTheme {
                val navController = rememberNavController()
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    NavigationComponent(Modifier.padding(innerPadding), navController)
                }
            }
        }
    }
}

@Composable
fun NavigationComponent(modifier: Modifier, navController: NavHostController) {
    NavHost(
        modifier = modifier,
        navController = navController,
        startDestination = Screen.Scan.route
    ) {
        composable(Screen.Scan.route) { ScanScreen(navController) }
        composable(Screen.ScanResult.route) { ScanResultScreen(navController) }
        composable(Screen.Operator.route) { OperatorScreen(navController) }
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
* splash screen
* ارقام الاختصارات
* push notifications
* analytics
* crashlytics
* in-app update
* in-app review
*
* */