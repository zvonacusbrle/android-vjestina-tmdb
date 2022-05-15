package com.company.tmdb.presentation.home

import androidx.lifecycle.ViewModel
import com.company.tmdb.repo.MovieRepository

class HomeViewModel(
    private val repository: MovieRepository
):ViewModel() {
        fun nesto(){
            print("AAAAAAAAAAAAAAAAAAAAA")
        }

}