package com.company.tmdb.presentation.home

import android.util.Log
import androidx.compose.foundation.layout.Box
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.company.tmdb.repo.MovieRepository
import kotlinx.coroutines.launch
import com.company.tmdb.presentation.Movie
import kotlinx.coroutines.flow.*
import org.koin.core.KoinApplication.Companion.init
import java.lang.reflect.Modifier

class HomeViewModel(
   private val repository: MovieRepository

):ViewModel() {

    var popularMovies: MutableList<Movie> = mutableListOf()


    init{
         viewModelScope.launch {
             repository.getPopularMovies().collect(){
                Log.i("LISTA FILMOVA", "${it}")
                 popularMovies.addAll(it)
             }
         }
     }

      @JvmName("getPopularMovies1")
      fun getPopularMovies(): MutableList<Movie> {

        return popularMovies
    }


}



