package com.company.tmdb.ui.theme.theme

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Checkbox
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.ListItem
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.company.tmdb.R

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun Movie(
    modifier: Modifier = Modifier,
    movie: MovieModel,
    onMovieClick: (MovieModel) -> Unit = {},
    onMovieCheckedChange: (MovieModel) -> Unit = {}
    )
{
    Card (
        modifier = modifier.fillMaxWidth(),
        shape = RoundedCornerShape(15.dp),
        elevation = 5.dp
    )
    {
        Box(modifier = Modifier.height(200.dp)){
            Image(
                painter = movie.picture,
                contentDescription = "nesto",
                contentScale = ContentScale.Crop
            )
            ListItem (
                trailing = {
                    if (movie.isCheckedOff != null) {
                    Checkbox(
                        

                        checked = movie.isCheckedOff,
                        onCheckedChange = { isChecked ->
                            val newMovieState = movie.copy(isCheckedOff = isChecked)
                            onMovieCheckedChange.invoke(newMovieState)
                        },
                        modifier = Modifier.padding(8.dp)
                    )
                }
        }

            ) {


            }
            

        }

    }




}

@Preview
@Composable
fun MoviePreview(){
    Movie(movie = MovieModel(1, "Kermit", "Action, War",
        "Not good not bad", false,  painterResource(id = R.drawable.kermit)))
}

data class MovieModel(
    val id: Long,
    val name: String,

    val movieType: String,

    val overview: String,
    val isCheckedOff: Boolean?,
    val picture: Painter




    )