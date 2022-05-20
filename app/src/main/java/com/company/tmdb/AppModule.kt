package com.company.tmdb


import com.company.tmdb.presentation.Movie


import com.company.tmdb.repo.MovieRepository
import com.company.tmdb.repo.MovieRepositoryImpl

import org.koin.dsl.module
import androidx.compose.runtime.getValue
import com.company.tmdb.presentation.home.HomeViewModel
import org.koin.androidx.viewmodel.dsl.viewModel

class Movie(private val movie: Movie)

val appModule = module{

    factory{com.company.tmdb.Movie(movie = get<Movie>())}

    single<MovieRepository>{
        MovieRepositoryImpl(get())
    }

    viewModel {
        HomeViewModel()
    }


}
