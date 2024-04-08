package com.project.picfol.app.SignUpSigIn.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.project.picfol.R

@Composable

fun GoogleFacebookIcon(
    googleClick: () -> Unit,
    facebookClick: () -> Unit
) {
    Row(
        modifier = Modifier.padding(
            start = 50.dp,
            end = 50.dp
        ),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {
        Box(
            modifier = Modifier
                .clip(CircleShape)
                .clickable {
                    googleClick()
                }
        ) {
            Image(
                painter = painterResource(id = R.drawable.icon_google),
                contentDescription = "Google Auth"
            )
        }
        Spacer(modifier = Modifier.width(15.dp))
        Box(modifier = Modifier
            .clip(CircleShape)
            .clickable {
                facebookClick()
            }) {
            Image(
                painter = painterResource(id = R.drawable.icon_facebook),
                contentDescription = "Google Auth"
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun P() {
    GoogleFacebookIcon({}, {})
}