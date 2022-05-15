package com.company.tmdb

import androidx.lifecycle.viewmodel.compose.viewModel
import com.company.tmdb.presentation.Movie
import com.company.tmdb.presentation.home.HomeViewModel
import com.company.tmdb.repo.MovieRepository
import com.company.tmdb.repo.MovieRepositoryImpl
import org.koin.core.scope.get
import org.koin.dsl.module

class Movie(private val movie: Movie)

val appModule = module{

    single<MovieRepository>{
        MovieRepositoryImpl(get())
    }

    single{com.company.tmdb.Movie(movie = get())}


}