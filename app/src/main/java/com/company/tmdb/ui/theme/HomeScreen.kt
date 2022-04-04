package com.company.tmdb.ui.theme

import android.util.Log
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.*
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview

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

}

@ExperimentalMaterialApi
@Composable
fun MovieList(
    movie: List<MovieModel>,
    onMovieCheckedChange: (MovieModel) -> Unit,
    onMovieClick: (MovieModel) -> Unit
) {
    LazyColumn {
        items(count = movie.size) { index ->
            val movie = movie[index]
            Movie(
                movieModel = movie,
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
        movie = listOf(
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
                isCheckedOff = false,
                movieType = "Action",
                overview = "None",
                picture = R.drawable.kermit

            )
        ),
        onMovieCheckedChange = {},
        onMovieClick = {}
    )
}



