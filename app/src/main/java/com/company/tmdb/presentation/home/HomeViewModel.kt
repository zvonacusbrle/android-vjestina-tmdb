package com.company.tmdb.presentation.home

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.company.tmdb.MovieApi
import com.company.tmdb.repo.MovieRepository
import kotlinx.coroutines.launch
import androidx.compose.runtime.getValue
import androidx.lifecycle.liveData
import com.company.tmdb.presentation.Movie
import com.company.tmdb.repo.MovieRepositoryImpl
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.flow.*
import org.koin.core.component.KoinComponent

 class HomeViewModel(
   private val repository: MovieRepository

):ViewModel() {

     suspend fun getPopularMovies() : Flow<List<Movie>>{
         Log.i("HWM", repository.getPopularMovies().toString())
         return repository.getPopularMovies()
    }



}

