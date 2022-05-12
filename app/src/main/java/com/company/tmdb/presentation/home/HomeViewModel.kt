package com.company.tmdb.presentation.home

import androidx.lifecycle.ViewModel
import com.company.tmdb.repo.MovieRepository

class HomeViewModel:ViewModel() {

    private val repository = MovieRepository()
}