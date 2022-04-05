package com.company.tmdb.ui.theme.theme

import android.util.Log
import android.view.RoundedCorner
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*

import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color

import androidx.compose.ui.res.painterResource

import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.company.tmdb.R
import com.company.tmdb.ui.theme.Shapes

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun Movie(
    modifier: Modifier = Modifier,
    movie: MovieModel,
    onMovieClick: (MovieModel) -> Unit = {},
    onMovieCheckedChange: (MovieModel) -> Unit = {}
    )
{
    Box(
        contentAlignment = Alignment.TopStart,
        modifier = Modifier
            .padding(3.dp)
            .clip(Shapes.small)
            .height(130.dp)


        ){
        Image(
            painterResource(id = R.drawable.kermit),
            contentDescription = "",
            modifier = modifier


        )


        FavoriteButton(modifier = Modifier.padding(10.dp), movie,
            Color.Black)


    }
    modifier.clickable { onMovieClick.invoke(movie) }

}



@Composable
fun FavoriteButton(
    modifier: Modifier = Modifier,
    movieModel: MovieModel,
    color: Color,
    onMovielick: (MovieModel) -> Unit = {},
    onMovieCheckedChange: (MovieModel) -> Unit = {}
) {

    var isFavorite by remember { mutableStateOf(false) }

    if(movieModel.isCheckedOff != null) {
        IconToggleButton(
        checked = movieModel.isCheckedOff!!,
        onCheckedChange = { isChecked ->

            val newModelState = movieModel.copy(isCheckedOff = isChecked)
            onMovieCheckedChange.invoke(newModelState)




        }
    ) {
            Icon(
                tint = color,
                imageVector = if(movieModel.isCheckedOff!!){
                    Icons.Filled.Favorite
                } else {
                    Icons.Default.FavoriteBorder
                },
                contentDescription = ""
            )

        }

    }
    
}






@Preview
@Composable
fun MoviePreview(){
Movie(movie = MovieModel(2, "Kermit", "Action, War",
        "Not good not bad",  true,  R.drawable.kermit
))
}

data class MovieModel(
    val id: Long,
    val name: String,

    val movieType: String,

    val overview: String,
    var isCheckedOff: Boolean? = null,
    val picture: Int




)