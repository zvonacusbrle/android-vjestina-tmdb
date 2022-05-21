package com.company.tmdb

import android.util.Log
import androidx.compose.runtime.*
import com.company.tmdb.presentation.Movie
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf

interface MovieApi {

    suspend fun getPopularMovies() : List<Movie>
}

class MovieApiImpl : MovieApi{
    override suspend fun getPopularMovies():  List<Movie> {
        return listOf(
            Movie(
                id = 1,
                name = "Avengers",
                isCheckedOff = true,
                movieType = "Action",
                overview = "None",
                picture = R.drawable.avengers_1,
                userScore = 72.0

            ),
            Movie(
                id = 1,
                name = "Avengers",
                isCheckedOff = true,
                movieType = "Action",
                overview = "None",
                picture = R.drawable.avengers_1,
                userScore = 72.0

            )
        )



    }

}


