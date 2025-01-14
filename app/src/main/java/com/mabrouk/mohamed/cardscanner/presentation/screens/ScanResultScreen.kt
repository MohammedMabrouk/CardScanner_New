package com.mabrouk.mohamed.cardscanner.presentation.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
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
import com.mabrouk.mohamed.cardscanner.R
import com.mabrouk.mohamed.cardscanner.presentation.compose.ActionButton
import com.mabrouk.mohamed.cardscanner.presentation.theme.White
import com.mabrouk.mohamed.cardscanner.presentation.theme.typography1


@Composable
fun ScanResultScreen(

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
                    .weight(1f),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                // used image
                Image(
                    modifier = Modifier
                        .height(250.dp)
                        .width(160.dp),
                    painter = painterResource(id = R.mipmap.logo),
                    contentDescription = "",
                    contentScale = ContentScale.FillBounds
                )
                ActionButton(
                    modifier = Modifier.padding(top = 30.dp),
                    onClick = {},
                    text = stringResource(id = R.string.next_btn)
                )
                // todo: handle result
            }
        }
    }
}

@Composable
@Preview(showBackground = true)
fun ScanResultScreenPreview() {
    ScanResultScreen()
}