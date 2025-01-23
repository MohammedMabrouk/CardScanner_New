package com.mabrouk.mohamed.cardscanner.presentation.screens

sealed class Screen(
    val route: String,
) {
    data object Scan : Screen("scan")
    data object ScanResult : Screen("scan_result")
    data object Operator : Screen("operator")
}