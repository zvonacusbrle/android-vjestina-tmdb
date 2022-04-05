package com.company.tmdb.ui.theme


import android.icu.text.CaseMap
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow

import androidx.compose.material.*

import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource

import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

import com.company.tmdb.R
import com.company.tmdb.ui.theme.theme.Movie
import com.company.tmdb.ui.theme.theme.MovieModel

@Composable
fun HomeScreen (){
    var movies by remember {
        mutableStateOf(
            listOf(
                MovieModel(
                    id = 1,
                    name = "Kermit",
                    isCheckedOff = false,
                    movieType = "Action",
                    overview = "None",
                    picture = R.drawable.kermit

                )
            )
        )
    }

    val rememberScaffoldState: ScaffoldState = rememberScaffoldState()



    ScaffoldCompose()

}

@Composable
fun ScaffoldCompose() {
    Scaffold(
        topBar = { TopAppBarCompose() }
    ) {}
}

@Composable
fun TopAppBarCompose(){
        TopAppBar(
            title = {
                Box(modifier = Modifier.fillMaxWidth()){
                    Image(painterResource(
                        id = R.drawable.tmdb_logo),
                        "Logo picture",
                        modifier = Modifier
                            .size(120.dp)
                            .align(Alignment.Center)





                    )
                }
            },

            actions = {},
            backgroundColor = Color(0xFF0B253F)


        )

}




    




@ExperimentalMaterialApi
@Composable
fun MovieList(
    movies: List<MovieModel>,
    onMovieCheckedChange: (MovieModel) -> Unit,
    onMovieClick: (MovieModel) -> Unit
) {
    LazyRow {
        items(count = movies.size) { index ->
            val movie = movies[index]
            Movie(
                movie = movie,
                onMovieClick = onMovieClick,
                onMovieCheckedChange = onMovieCheckedChange
            )

        }
    }
}


@ExperimentalMaterialApi
@Preview
@Composable
fun MovieListPreview() {
    MovieList(
        movies = listOf(
            MovieModel(
                id = 1,
                name = "Kermit",
                isCheckedOff = false,
                movieType = "Action",
                overview = "None",
                picture = R.drawable.kermit

            ),
            MovieModel(
                id = 2,
                name = "Kermit",
                isCheckedOff = true,
                movieType = "Action",
                overview = "None",
                picture = R.drawable.kermit

            ),
            MovieModel(
                id = 3,
                name = "Kermit",
                isCheckedOff = true,
                movieType = "Action",
                overview = "None",
                picture = R.drawable.kermit

            )
        ),
        onMovieCheckedChange = {},
        onMovieClick = {}
    )
}



