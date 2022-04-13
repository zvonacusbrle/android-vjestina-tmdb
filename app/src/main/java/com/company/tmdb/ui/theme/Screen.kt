package com.company.tmdb.ui.theme

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.Home
import androidx.compose.ui.graphics.vector.ImageVector

sealed class BottomBarScreen(
    val  route: String,
    val title: String,
    var icon: ImageVector

){
    object Home: BottomBarScreen(
        route = "home",
        title = "Home",
        icon = Icons.Default.Home
    )

    object Favorite: BottomBarScreen(
        route = "favorite",
        title = "Favorite",
        icon = Icons.Default.FavoriteBorder
    )
}

sealed class DetailScreen(
    val route: String,
    val title: String
){
    object Details: DetailScreen(
        route = "details",
        title = "Details"
    )
}
