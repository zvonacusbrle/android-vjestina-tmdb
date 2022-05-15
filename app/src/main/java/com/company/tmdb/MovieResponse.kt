package com.company.tmdb

import androidx.compose.runtime.*
import com.company.tmdb.presentation.Movie


class MovieResponse{

}

@Composable
fun movies(): MutableList<Movie> {
    var movies by remember {
        mutableStateOf(
            mutableListOf(
                Movie(
                    id = 1,
                    name = "Kermit",
                    isCheckedOff = true,
                    movieType = "Action",
                    overview = "None",
                    picture = R.drawable.avengers_1,
                    userScore = 72.0

                ),

                Movie(
                    id = 2,
                    name = "Kermit",
                    isCheckedOff = true,
                    movieType = "Action",
                    overview = "None",
                    picture = R.drawable.iron_man_1,
                    userScore = 72.0

                ),
                Movie(
                    id = 3,
                    name = "Kermit",
                    isCheckedOff = true,
                    movieType = "Action",
                    overview = "None",
                    picture = R.drawable.puppy_love,
                    userScore = 72.0

                ),
                Movie(
                    id = 4,
                    name = "Kermit",
                    isCheckedOff = true,
                    movieType = "Action",
                    overview = "None",
                    picture = R.drawable.puppy_love,
                    userScore = 72.0

                ),
                Movie(
                    id = 5,
                    name = "Kermit",
                    isCheckedOff = true,
                    movieType = "Action",
                    overview = "None",
                    picture = R.drawable.puppy_love,
                    userScore = 72.0

                ),
                Movie(
                    id = 6,
                    name = "Kermit",
                    isCheckedOff = true,
                    movieType = "Action",
                    overview = "None",
                    picture = R.drawable.puppy_love,
                    userScore = 72.0

                ),
                Movie(
                    id = 7,
                    name = "Kermit",
                    isCheckedOff = true,
                    movieType = "Action",
                    overview = "None",
                    picture = R.drawable.puppy_love,
                    userScore = 72.0

                ),
                Movie(
                    id = 8,
                    name = "Kermit",
                    isCheckedOff = true,
                    movieType = "Action",
                    overview = "None",
                    picture = R.drawable.puppy_love,
                    userScore = 72.0

                ),
                Movie(
                    id = 9,
                    name = "Kermit",
                    isCheckedOff = true,
                    movieType = "Action",
                    overview = "None",
                    picture = R.drawable.puppy_love,
                    userScore = 72.0

                ),
                Movie(
                    id = 10,
                    name = "Kermit",
                    isCheckedOff = true,
                    movieType = "Action",
                    overview = "None",
                    picture = R.drawable.puppy_love,
                    userScore = 72.0

                ),
                Movie(
                    id = 11,
                    name = "Kermit",
                    isCheckedOff = true,
                    movieType = "Action",
                    overview = "None",
                    picture = R.drawable.puppy_love,
                    userScore =  72.0

                )

            )
        )
    }
    return movies
}

