package com.company.tmdb

import androidx.compose.runtime.*
import androidx.lifecycle.ViewModel
import com.company.tmdb.presentation.Movie
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow


class MovieResponse : ViewModel(){
    var movies = {

                Movie(
                    id = 1,
                    name = "Avengers",
                    isCheckedOff = true,
                    movieType = "Action",
                    overview = "None",
                    picture = R.drawable.avengers_1,
                    userScore = 72.0

                )

                Movie(
                    id = 2,
                    name = "Gattaca",
                    isCheckedOff = true,
                    movieType = "Action",
                    overview = "None",
                    picture = R.drawable.iron_man_1,
                    userScore = 72.0

                )
                Movie(
                    id = 3,
                    name = "Puppy Love",
                    isCheckedOff = false,
                    movieType = "Action",
                    overview = "None",
                    picture = R.drawable.puppy_love,
                    userScore = 72.0

                )


    }
}

