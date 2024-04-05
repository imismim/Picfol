package com.project.picfol.app.SignUpSigIn.presentation.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.project.picfol.ui.theme.CoolGray

@Composable
fun ClickableText(text: String, clickableText: String, click: () -> Unit) {
    Row(
        Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Start,
    ) {
        Text(text = text, color = CoolGray, style = MaterialTheme.typography.labelSmall)
        Text(text = clickableText, color = Color.Blue, style = MaterialTheme.typography.labelSmall, modifier = Modifier.clickable{
            click()
        })

    }
}
