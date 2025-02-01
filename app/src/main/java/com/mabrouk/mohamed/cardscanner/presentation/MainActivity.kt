package com.mabrouk.mohamed.cardscanner.presentation

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.mabrouk.mohamed.cardscanner.presentation.screens.OperatorScreen
import com.mabrouk.mohamed.cardscanner.presentation.screens.OperatorType
import com.mabrouk.mohamed.cardscanner.presentation.screens.Screen
import com.mabrouk.mohamed.cardscanner.presentation.screens.scan.ScanScreen
import com.mabrouk.mohamed.cardscanner.presentation.theme.CardScanner_NewTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CardScanner_NewTheme {
                val navController = rememberNavController()
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    NavigationComponent(
                        Modifier.padding(innerPadding),
                        navController
                    ) { type, num ->
                        makeCall(num, type)
                    }
                }
            }
        }
    }

    private fun makeCall(number: String, operatorType: OperatorType) {
        val finalNum = when (operatorType) {
            OperatorType.ETISALAT -> "*556*$number#"
            OperatorType.VODAFONE -> "*858*$number#"
            OperatorType.ORANGE -> "*102*$number#"
            OperatorType.WE -> "*555*$number#"
        }
        val intent = Intent(Intent.ACTION_DIAL, Uri.fromParts("tel", finalNum, null))
        startActivity(intent)
    }
}

@Composable
fun NavigationComponent(
    modifier: Modifier,
    navController: NavHostController,
    onOperatorClick: (OperatorType, number: String) -> Unit,
) {
    NavHost(
        modifier = modifier,
        navController = navController,
        startDestination = Screen.Scan.route
    ) {
        composable(Screen.Scan.route) { ScanScreen(navController) }
        composable(
            "${Screen.Operator.route}/{number}",
            arguments = listOf(navArgument("number") { type = NavType.StringType })
        ) { backStackEntry ->
            val number = backStackEntry.arguments?.getString("number") ?: ""
            OperatorScreen(number, navController) { type, num ->
                onOperatorClick(type, num)
            }
        }
    }
}

// Plan

// todo: fix app icon
/*
settings screen
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