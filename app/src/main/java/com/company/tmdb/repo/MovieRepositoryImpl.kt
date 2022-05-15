package com.company.tmdb.repo

import android.util.Log
import com.company.tmdb.MovieApi
import com.company.tmdb.presentation.Movie
import kotlinx.coroutines.flow.Flow

class MovieRepositoryImpl(
    private val movieApi: MovieApi
): MovieRepository {
    override suspend fun getMovies(){
        val film = movieApi.getPopularMovies()


    }
}