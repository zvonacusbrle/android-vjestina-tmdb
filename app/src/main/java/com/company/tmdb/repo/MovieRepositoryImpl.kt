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
        val movieZ : Flow<List<Movie>> = flow{
            while(true){
                val lastMovieX = movieApi.getPopularMovies()
                Log.i("EMIT", "${emit(lastMovieX)}")
                kotlinx.coroutines.delay(5000)


            }
        }
        Log.i("MOVIEAPI", movieZ.toString())
        return movieZ
    }
}