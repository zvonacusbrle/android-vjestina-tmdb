package com.company.tmdb.repo

import com.company.tmdb.presentation.Movie
import kotlinx.coroutines.flow.Flow

interface MovieRepository {

    fun getMovies() : Flow<List<Movie>>
}