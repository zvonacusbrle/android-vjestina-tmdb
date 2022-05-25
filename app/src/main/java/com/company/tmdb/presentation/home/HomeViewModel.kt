package com.company.tmdb.presentation.home

import android.util.Log
import androidx.compose.foundation.layout.Box
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.company.tmdb.repo.MovieRepository
import kotlinx.coroutines.launch
import com.company.tmdb.presentation.Movie
import kotlinx.coroutines.flow.*
import java.lang.reflect.Modifier

class HomeViewModel(
   private val repository: MovieRepository

):ViewModel() {

     /*private val _movies : MutableLiveData<List<Movie>> by lazy {
         MutableLiveData<List<Movie>>.also {
             getPopularMovies()
         }
     }*/

     init{
         viewModelScope.launch {
             repository.getPopularMovies().collect(){

             }
         }
     }





  



}

