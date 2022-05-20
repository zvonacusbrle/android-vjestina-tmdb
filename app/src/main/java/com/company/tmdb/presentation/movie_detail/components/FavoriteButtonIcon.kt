package com.company.tmdb.presentation.movie_detail.components

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Icon
import androidx.compose.material.IconToggleButton
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.filled.StarBorder
import androidx.compose.material.icons.outlined.Star
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.company.tmdb.R
import com.company.tmdb.navigation.Screen
import com.company.tmdb.presentation.Movie
import com.company.tmdb.presentation.theme.Shapes
import com.company.tmdb.presentation.theme.favoriteButtonBackgorund
import org.koin.core.component.KoinComponent

@Composable
fun FavoriteButtonIcon(movie: Movie) {
    Box(
        modifier = Modifier
            .size(30.dp)

            .fillMaxWidth()
            .background(
                color = favoriteButtonBackgorund,
                shape = CircleShape
            )
            .clickable {  },

        contentAlignment = Alignment.Center
    )
    {

        Icon(imageVector = when(movie.isCheckedOff){
            false-> Icons.Default.StarBorder
            else -> Icons.Default.Star
        },
            contentDescription = "Favorite icon",
            modifier = Modifier
                .padding(5.dp),
            tint = Color.White
        )
    }

}



@Preview
@Composable
fun FavoriteButtonIconTrue(){
    FavoriteButtonIcon(movie = Movie(2, "Zeljezni covjek", "Action, War",
        "Not good not bad",  true,  R.drawable.iron_man_1, 75.0))
}

@Preview
@Composable
fun FavoriteButtonIconFalse(){
    FavoriteButtonIcon(movie = Movie(2, "Zeljezni covjek", "Action, War",
        "Not good not bad",  false,  R.drawable.iron_man_1, 75.0))
}