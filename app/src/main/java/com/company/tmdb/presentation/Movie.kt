package com.company.tmdb.ui.theme.theme

import android.os.Parcelable
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
import androidx.navigation.NavController
import com.company.tmdb.R
import com.company.tmdb.ui.theme.Screen
import com.company.tmdb.ui.theme.Shapes
import kotlinx.parcelize.Parcelize

@OptIn(ExperimentalMaterialApi::class)
@Composable



fun Movie(

    modifier: Modifier = Modifier,
    navController: NavController,
    movie: Movie,
    onMovieCheckedChange: (Movie) -> Unit = {}

    )
{
    Box(
        contentAlignment = Alignment.TopStart,
        modifier = Modifier
            .padding(5.dp)
            .clip(Shapes.small)
            .clickable {
                navController.currentBackStackEntry?.savedStateHandle?.set("movie", movie)

                navController.navigate(route = Screen.Details.route)
                Log.i("Nav slicl", " PRITISNUTO JE ")

            }






        ){
        Image(

            painterResource(id = movie.picture),
            contentDescription = "Movie image",
            modifier = modifier
                .height(179.dp)
                .width(122.dp)
        )


        ListItem (


            trailing = { if(movie.isCheckedOff != null) {
                Box(modifier = Modifier
                    .fillMaxWidth()
                    .clickable {
                        navController.navigate(route = Screen.Details.route)
                        Log.i("Nav clicl", " PRITISNUTO JE ")
                    },
                    Alignment.TopStart)
                {
                IconToggleButton(

                    checked = movie.isCheckedOff!!,
                    onCheckedChange = { isChecked ->
                        Log.i("STANJE1 ", "$isChecked")
                        val newModelState = movie.copy(isCheckedOff = isChecked)
                        onMovieCheckedChange.invoke(newModelState)
                        Log.i("STANJE2 ", "$isChecked")

                    }
                ) {

                        Icon(

                            tint = Color.White,
                            imageVector = if(movie.isCheckedOff!!){
                                Icons.Filled.Favorite
                            } else {
                                Icons.Default.FavoriteBorder
                            },
                            contentDescription = ""
                        )

                    }

                }
                }
            },

            text = {Unit}
        )


    }


}








/*
@Preview
@Composable
fun MoviePreview(){
Movie(movie = MovieModel(2, "Zeljezni covjek", "Action, War",
        "Not good not bad",  true,  R.drawable.iron_man_1
))
}

 */

@Parcelize
data class Movie(
    val id: Long,
    val name: String,
    val movieType: String,
    val overview: String,
    var isCheckedOff: Boolean? = null,
    val picture: Int
) : Parcelable