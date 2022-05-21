package com.company.tmdb


import com.company.tmdb.presentation.Movie


import com.company.tmdb.repo.MovieRepository
import com.company.tmdb.repo.MovieRepositoryImpl

import org.koin.dsl.module
import androidx.compose.runtime.getValue
import com.company.tmdb.presentation.home.HomeViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.scope.get


val appModule = module{

    single<MovieApi>{
        MovieApiImpl()
    }

    single<MovieRepository>{
        MovieRepositoryImpl(get())
    }


    viewModel {
        HomeViewModel(get())
    }


}
