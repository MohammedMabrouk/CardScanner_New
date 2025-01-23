package com.mabrouk.mohamed.cardscanner.presentation.screens.scan

import android.Manifest
import android.graphics.Bitmap
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.activity.result.launch
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
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.google.accompanist.permissions.ExperimentalPermissionsApi
import com.google.accompanist.permissions.isGranted
import com.google.accompanist.permissions.rememberPermissionState
import com.mabrouk.mohamed.cardscanner.R
import com.mabrouk.mohamed.cardscanner.presentation.compose.ActionButton
import com.mabrouk.mohamed.cardscanner.presentation.theme.White
import com.mabrouk.mohamed.cardscanner.presentation.theme.typography1

@OptIn(ExperimentalPermissionsApi::class)
@Composable
fun ScanScreen(
    navController: NavHostController,
    viewModel: ScanViewModel = hiltViewModel(),
) {
    val detectorResult by viewModel.detectorResult.collectAsState()
    var bitmap: Bitmap? by remember { mutableStateOf(null) }
    val cameraPermissionState = rememberPermissionState(Manifest.permission.CAMERA)

    // Camera launcher
    val takePictureLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.TakePicturePreview()
    ) { capturedBitmap ->
        if (capturedBitmap != null) {
            bitmap = capturedBitmap
            bitmap?.let {
                viewModel.processImage(it)
            }
        }
    }

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
                    onClick = {
                        if (cameraPermissionState.status.isGranted) {
                            takePictureLauncher.launch()
                        } else {
                            cameraPermissionState.launchPermissionRequest()
                        }
                    },
                    text = stringResource(id = R.string.start_btn)
                )
            }
        }
    }
}

@Composable
@Preview(showBackground = true)
fun ScanScreenPreview() {
    ScanScreen(rememberNavController())
}