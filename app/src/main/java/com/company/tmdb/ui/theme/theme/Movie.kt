package com.company.tmdb.ui.theme.theme

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

import androidx.compose.ui.res.painterResource

import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.company.tmdb.R

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun Movie(
    modifier: Modifier = Modifier,
    movieModel: MovieModel,
    onMovieClick: (MovieModel) -> Unit = {},
    onMovieCheckedChange: (MovieModel) -> Unit = {}
    )
{
    Box(contentAlignment = Alignment.TopStart){
        Image(
            painterResource(id = R.drawable.kermit),
            contentDescription = "",
            modifier = modifier,

        )
        FavoriteButton(modifier = Modifier.padding(12.dp), movieModel,
            Color.Black)


    }

}



@Composable
fun FavoriteButton(
    modifier: Modifier = Modifier,
    movieModel: MovieModel,
    color: Color,
    onMovielick: (MovieModel) -> Unit = {},
    onMovieCheckedChange: (MovieModel) -> Unit = {}
) {

    movieModel.isCheckedOff?.let {
        IconToggleButton(
        checked = it,
        onCheckedChange = { isChecked ->
            val newNoteState = movieModel.copy(isCheckedOff = isChecked)
            onMovieCheckedChange.invoke(newNoteState)
        }
    ) {
            Icon(
                tint = color,
                imageVector = if(movieModel.isCheckedOff){
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
Movie(movieModel = MovieModel(2, "Kermit", "Action, War",
        "Not good not bad",  true,  R.drawable.kermit
))
}

data class MovieModel(
    val id: Long,
    val name: String,

    val movieType: String,

    val overview: String,
    val isCheckedOff: Boolean?,
    val picture: Int




)