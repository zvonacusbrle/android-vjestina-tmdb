package com.company.tmdb.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.Home
import androidx.compose.ui.graphics.vector.ImageVector

sealed class Screen(
    val  route: String,
    val title: String,
    var icon: ImageVector? = null

){
    object Home: Screen(
        route = "home_screen",
        title = "Home",
        icon = Icons.Default.Home
    )

    object Favorite: Screen(
        route = "favorite_screen",
        title = "Favorite",
        icon = Icons.Default.FavoriteBorder
    )
    object Details: Screen(
        route = "details_screen",
        title = "Details"

    )
}

