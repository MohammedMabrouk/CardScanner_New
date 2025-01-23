package com.mabrouk.mohamed.cardscanner.presentation.compose

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.mabrouk.mohamed.cardscanner.R
import com.mabrouk.mohamed.cardscanner.presentation.theme.Blue
import com.mabrouk.mohamed.cardscanner.presentation.theme.Green
import com.mabrouk.mohamed.cardscanner.presentation.theme.typography1

@Composable
fun ActionButton(
    modifier: Modifier,
    onClick: () -> Unit,
    text: String,
) {
    Button(
        modifier = modifier.height(50.dp),
        onClick = { onClick() },
        colors = ButtonDefaults.buttonColors(
            containerColor = Green,
            contentColor = Blue
        ),
        shape = RoundedCornerShape(10.dp),
    ) {
        Text(text, style = typography1.labelLarge)
    }
}

@Composable
@Preview
fun ActionButtonPreview() {
    ActionButton(
        modifier = Modifier,
        onClick = {},
        text = "Hello World"
    )
}


@Composable
fun SelectionButton(
    modifier: Modifier,
    onClick: () -> Unit,
    text: String,
    iconResource: Int
) {
    Button(
        modifier = modifier.height(50.dp),
        onClick = { onClick() },
        colors = ButtonDefaults.buttonColors(
            containerColor = Green,
            contentColor = Blue
        ),
        shape = RoundedCornerShape(10.dp),
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement =Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                modifier = Modifier
                    .padding(horizontal = 8.dp)
                    .size(35.dp),
                painter = painterResource(id = iconResource),
                contentDescription = "",
                contentScale = ContentScale.FillBounds
            )
            Text(text, style = typography1.labelLarge)
            Spacer(modifier = Modifier.width(35.dp).padding(horizontal = 8.dp))
        }
    }
}

@Composable
@Preview
fun SelectionButtonPreview() {
    SelectionButton(
        modifier = Modifier,
        onClick = {},
        text = "Hello World",
        iconResource = R.mipmap.logo
    )
}