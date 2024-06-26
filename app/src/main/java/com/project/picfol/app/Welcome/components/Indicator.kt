package com.project.picfol.app.Welcome.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import com.project.picfol.app.NavGraph.Dimens.IndicatorSize
import com.project.picfol.ui.theme.CoolGray
import com.project.picfol.ui.theme.UltraViolet

@Composable
fun PageIndicator(
    modifier: Modifier,
    pageSize: Int,
    selectPage: Int,
    selectedColor: Color = UltraViolet,
    unselectedColor: Color = CoolGray
) {
    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        repeat(pageSize) { page ->
            Box(
                modifier = Modifier.size(IndicatorSize).clip(CircleShape)
                    .background(color = if (page == selectPage) selectedColor else unselectedColor)
            )
        }
    }
}