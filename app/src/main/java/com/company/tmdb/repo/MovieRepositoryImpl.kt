package com.company.tmdb.repo

import android.util.Log
import com.company.tmdb.MovieApi
import com.company.tmdb.MovieApiImpl
import com.company.tmdb.presentation.Movie
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

 class MovieRepositoryImpl(
    private val movieApi: MovieApi
): MovieRepository {
    override suspend fun getPopularMovies() : Flow<List<Movie>>{
        val popularMovies : Flow<List<Movie>> = flow{
            while(true){
                val lastMovie = movieApi.getPopularMovies()
                Log.i("EMIT", "${emit(lastMovie)}")
                kotlinx.coroutines.delay(5000)
            }
        }

        return popularMovies
    }
}