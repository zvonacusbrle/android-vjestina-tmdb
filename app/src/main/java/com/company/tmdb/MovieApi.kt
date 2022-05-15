package com.company.tmdb

interface MovieApi {

    suspend fun getPopularMovies()
}

internal class MovieApiImpl : MovieApi{
    override suspend fun getPopularMovies() {
        TODO("Not yet implemented")
    }

}


