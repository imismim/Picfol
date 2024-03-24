package com.project.picfol.Welcome

import androidx.annotation.DrawableRes
import com.project.picfol.R

data class Page(
    val title: String,
    val description: String,
    @DrawableRes val image: Int
)


val pages = listOf(
    Page(
        title = "First welcome screen",
        description = "Some description for first welcome screen",
        image = R.drawable.icon_splashscreen
    ),
    Page(
        title = "Second welcome screen",
        description = "Some description for second welcome screen",
        image = R.drawable.icon_splashscreen
    ),
    Page(
        title = "Third welcome screen",
        description = "Some description for third welcome screen",
        image = R.drawable.icon_splashscreen
    )
)
