@file:OptIn(ExperimentalMaterial3Api::class)

package com.project.picfol.app.SignUpSigIn.presentation.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.project.picfol.ui.theme.CoolGray
import com.project.picfol.ui.theme.UltraViolet

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TextField(textValue: MutableState<String>, labelValue: String, icon: Int) {
    OutlinedTextField(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(4.dp)),
        label = { Text(text = labelValue) },
        colors = TextFieldDefaults.outlinedTextFieldColors(
            focusedBorderColor = UltraViolet,
            focusedLabelColor = UltraViolet,
            cursorColor = UltraViolet,
            focusedTextColor = CoolGray,
            unfocusedTextColor = CoolGray
        ),
        keyboardOptions = KeyboardOptions.Default,
        value = textValue.value,
        onValueChange = {
            textValue.value = it
        },
        leadingIcon = {
            Icon(painter = painterResource(id = icon), contentDescription = "")
        })
}