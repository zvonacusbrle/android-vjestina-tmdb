package com.company.tmdb.ui.theme

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.company.tmdb.R
import com.company.tmdb.ui.theme.theme.Movie

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun FavoriteScreen (){
    var movies by remember {
        mutableStateOf(
            mutableListOf(
                Movie(
                    id = 1,
                    name = "Kermit",
                    isCheckedOff = true,
                    movieType = "Action",
                    overview = "None",
                    picture = R.drawable.avengers_1

                ),

                Movie(
                    id = 2,
                    name = "Kermit",
                    isCheckedOff = true,
                    movieType = "Action",
                    overview = "None",
                    picture = R.drawable.iron_man_1

                ),
                Movie(
                    id = 3,
                    name = "Kermit",
                    isCheckedOff = true,
                    movieType = "Action",
                    overview = "None",
                    picture = R.drawable.puppy_love

                ),
                Movie(
                    id = 4,
                    name = "Kermit",
                    isCheckedOff = true,
                    movieType = "Action",
                    overview = "None",
                    picture = R.drawable.puppy_love

                ),
                Movie(
                    id = 5,
                    name = "Kermit",
                    isCheckedOff = true,
                    movieType = "Action",
                    overview = "None",
                    picture = R.drawable.puppy_love

                ),
                Movie(
                    id = 6,
                    name = "Kermit",
                    isCheckedOff = true,
                    movieType = "Action",
                    overview = "None",
                    picture = R.drawable.puppy_love

                ),
                Movie(
                    id = 7,
                    name = "Kermit",
                    isCheckedOff = true,
                    movieType = "Action",
                    overview = "None",
                    picture = R.drawable.puppy_love

                ),
                Movie(
                    id = 8,
                    name = "Kermit",
                    isCheckedOff = true,
                    movieType = "Action",
                    overview = "None",
                    picture = R.drawable.puppy_love

                ),
                Movie(
                    id = 9,
                    name = "Kermit",
                    isCheckedOff = true,
                    movieType = "Action",
                    overview = "None",
                    picture = R.drawable.puppy_love

                ),
                Movie(
                    id = 10,
                    name = "Kermit",
                    isCheckedOff = true,
                    movieType = "Action",
                    overview = "None",
                    picture = R.drawable.puppy_love

                ),
                Movie(
                    id = 11,
                    name = "Kermit",
                    isCheckedOff = true,
                    movieType = "Action",
                    overview = "None",
                    picture = R.drawable.puppy_love

                )

            )
        )
    }


    Box(
        modifier = Modifier
            .background(backgroundColorApp)
            .fillMaxSize()
    ){

        Column() {
            Scaffold(
                topBar = { TopAppBarCompose() },

                content = {

                    Column(
                        modifier = Modifier


                    ) {
                        Spacer(modifier = Modifier.height(40.dp))
                        sectionTitle("Favorite")
                        
                        if (movies.isNotEmpty()) {

                            MoviesGridList(

                                movies,
                                onMovieCheckedChange = { updatedMovie ->

                                    val index = movies.indexOfFirst { it.id == updatedMovie.id }
                                    movies = movies.toMutableList().apply { set(index, updatedMovie) }
                                },
                                onMovieClick = {

                                }

                            )
                        }


                    }


                }
            )
        }

    }






}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun MoviesGridList(
    movies: MutableList<Movie>,
    onMovieCheckedChange: (Movie) -> Unit,
    onMovieClick: (Movie) -> Unit
)
{
    LazyVerticalGrid(
        cells = GridCells.Fixed(3),
        contentPadding = PaddingValues(start = 10.dp, end = 10.dp, bottom = 100.dp),
        modifier = Modifier.fillMaxHeight()
    ){
        items(count = movies.size) { index ->
            val movie = movies[index]
            Movie(
                movie = movie,
                onMovieClick = onMovieClick,
                onMovieCheckedChange = onMovieCheckedChange
            )

        }

    }

}



