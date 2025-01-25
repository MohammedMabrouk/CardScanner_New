package com.mabrouk.mohamed.cardscanner.presentation.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.mabrouk.mohamed.cardscanner.R
import com.mabrouk.mohamed.cardscanner.presentation.compose.SelectionButton
import com.mabrouk.mohamed.cardscanner.presentation.theme.White
import com.mabrouk.mohamed.cardscanner.presentation.theme.typography1


@Composable
fun OperatorScreen(
    detectedNumber: String,
    navController: NavHostController,
    onOperatorClick: (OperatorType, String) -> Unit,
) {
    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        Image(
            modifier = Modifier.fillMaxSize(),
            painter = painterResource(id = R.mipmap.background),
            contentDescription = "",
            contentScale = ContentScale.FillBounds
        )
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = stringResource(id = R.string.app_name),
                    style = typography1.titleLarge
                )
                Icon(
                    imageVector = Icons.Filled.Settings,
                    contentDescription = "setting icon",
                    tint = White
                )
            }

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 50.dp)
                    .weight(1f),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                SelectionButton(
                    modifier = Modifier.fillMaxWidth(),
                    onClick = { onOperatorClick(OperatorType.ETISALAT, detectedNumber) },
                    text = stringResource(id = R.string.etisalat),
                    iconResource = R.drawable.ic_etisalat
                )
                SelectionButton(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 30.dp),
                    onClick = { onOperatorClick(OperatorType.VODAFONE, detectedNumber) },
                    text = stringResource(id = R.string.vodafone),
                    iconResource = R.drawable.ic_vodafone
                )
                SelectionButton(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 30.dp),
                    onClick = { onOperatorClick(OperatorType.ORANGE, detectedNumber) },
                    text = stringResource(id = R.string.orange),
                    iconResource = R.drawable.ic_orange
                )
                SelectionButton(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 30.dp),
                    onClick = { onOperatorClick(OperatorType.WE, detectedNumber) },
                    text = stringResource(id = R.string.we),
                    iconResource = R.drawable.ic_we
                )
            }
        }
    }
}

@Composable
@Preview(showBackground = true)
fun OperatorScreenPreview() {
    OperatorScreen("123", rememberNavController()) { _, _ -> }
}

enum class OperatorType {
    ETISALAT,
    VODAFONE,
    ORANGE,
    WE
}