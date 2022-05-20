package com.company.tmdb.repo

import com.company.tmdb.presentation.Movie
import kotlinx.coroutines.flow.Flow
import org.koin.core.component.KoinComponent

interface MovieRepository {

    suspend fun getPopularMovies() : Flow<List<Movie>>
}