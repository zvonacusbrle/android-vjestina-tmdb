package com.company.tmdb.presentation.theme



import android.util.Log
import androidx.compose.foundation.*
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight


import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController

import com.company.tmdb.R
import com.company.tmdb.presentation.Movie
import com.company.tmdb.presentation.home.HomeViewModel
import androidx.compose.runtime.getValue
import androidx.lifecycle.ViewModel


@ExperimentalMaterialApi
@Composable
fun HomeScreen (navController: NavController) {

    val viewModel = viewModel<HomeViewModel>()
    viewModel.nesto()


    var movies by remember {
        mutableStateOf(
            mutableListOf(
                Movie(
                    id = 1,
                    name = "Avengers",
                    isCheckedOff = true,
                    movieType = "Action",
                    overview = "None",
                    picture = R.drawable.avengers_1,
                    userScore = 72.0

                ),

                Movie(
                    id = 2,
                    name = "Gattaca",
                    isCheckedOff = true,
                    movieType = "Action",
                    overview = "None",
                    picture = R.drawable.iron_man_1,
                    userScore = 72.0

                ),
                Movie(
                    id = 3,
                    name = "Puppy Love",
                    isCheckedOff = false,
                    movieType = "Action",
                    overview = "None",
                    picture = R.drawable.puppy_love,
                    userScore = 72.0

                )
            )
        )
    }

    var popularMovies by remember {
        mutableStateOf(
            mutableListOf(
                Movie(
                    id = 1,
                    name = "Kermit",
                    isCheckedOff = true,
                    movieType = "Action",
                    overview = "None",
                    picture = R.drawable.jungle_beat,
                    userScore = 72.0

                ),

                Movie(
                    id = 2,
                    name = "Kermit",
                    isCheckedOff = true,
                    movieType = "Action",
                    overview = "None",
                    picture = R.drawable.jungle_beat,
                    userScore = 72.0

                ),
                Movie(
                    id = 3,
                    name = "Kermit",
                    isCheckedOff = false,
                    movieType = "Action",
                    overview = "None",
                    picture = R.drawable.jungle_beat,
                    userScore = 72.0

                )
            )
        )
    }

    var upcomingMovies by remember {
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
                    picture = R.drawable.jungle_beat,
                    userScore = 72.0

                ),
                Movie(
                    id = 3,
                    name = "Kermit",
                    isCheckedOff = false,
                    movieType = "Action",
                    overview = "None",
                    picture = R.drawable.puppy_love,
                    userScore = 72.0

                ),
                Movie(
                    id = 4,
                    name = "Kermit",
                    isCheckedOff = false,
                    movieType = "Action",
                    overview = "None",
                    picture = R.drawable.jungle_beat,
                    userScore = 72.0

                )
            )
        )
    }



    val scrollState = rememberScrollState()



    Box(
        modifier = Modifier
            .background(backgroundColorApp)
            .fillMaxSize()
            .padding(bottom = 50.dp)





    ){
        Column() {

            Scaffold(
                modifier = Modifier.padding(),
                topBar = { TopAppBarCompose(navController = navController) },

                content = {

                    Column(
                        modifier = Modifier
                            .verticalScroll(scrollState)



                    ) {

                        searchBar()
                        sectionTitle("What's up")
                        whatsUpToolBar()
                        Spacer(modifier = Modifier.height(4.dp))
                        if (movies.isNotEmpty()) {

                            MovieList(

                                navController = navController,
                                movies,
                                onMovieCheckedChange = { updatedMovie ->

                                    val index = movies.indexOfFirst { it.id == updatedMovie.id }
                                    movies = movies.toMutableList().apply { set(index, updatedMovie) }


                                },


                            )
                        }

                        sectionTitle("Free to watch")


                        if (popularMovies.isNotEmpty()) {

                            MovieList(
                                navController = navController,

                                popularMovies,
                                onMovieCheckedChange = { updatedMovie ->

                                    val index = popularMovies.indexOfFirst { it.id == updatedMovie.id }
                                    popularMovies = popularMovies.toMutableList().apply { set(index, updatedMovie) }
                                },


                            )
                        }
                        sectionTitle("Upcoming")

                        if (upcomingMovies.isNotEmpty()) {

                            MovieList(
                                navController = navController,

                                upcomingMovies,
                                onMovieCheckedChange = { updatedMovie ->

                                    val index = upcomingMovies.indexOfFirst { it.id == updatedMovie.id }
                                    upcomingMovies = upcomingMovies.toMutableList().apply { set(index, updatedMovie) }
                                },


                            )
                        }

                        if (upcomingMovies.isNotEmpty()) {

                            MovieList(
                                navController = navController,

                                upcomingMovies,
                                onMovieCheckedChange = { updatedMovie ->

                                    val index = upcomingMovies.indexOfFirst { it.id == updatedMovie.id }
                                    upcomingMovies = upcomingMovies.toMutableList().apply { set(index, updatedMovie) }
                                }

                            )
                        }

                    }
                }

            )


        }


    }

}



@Composable
fun sectionTitle(titleName: String) {
    Column() {
        Text(
            text = titleName,
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,

            modifier = Modifier
                .padding(8.dp)
        )
    }

}


@Composable
    fun whatsUpToolBar() {

        var tabIndex by remember { mutableStateOf(0) }
        val tabData = listOf("Popular", "Top Rated")

        TabRow(
            selectedTabIndex = tabIndex,
            modifier = Modifier
                .fillMaxWidth(0.6f)
                .wrapContentHeight()
                .padding(5.dp),

            contentColor = Color.Black,
            backgroundColor = Color.White
        ) {

            tabData.forEachIndexed { index, data ->
                val selected = tabIndex == index

                Tab(
                    selected = selected,
                    onClick = {
                        tabIndex = index
                    },
                    modifier = Modifier,
                    enabled = true,
                    text = {
                        Text(
                            text = data,
                            fontWeight = FontWeight.Bold
                        )
                    },
                    interactionSource = MutableInteractionSource()
                )

            }


        }


    }


    @Composable
    fun searchBar(
        modifier: Modifier = Modifier,
        hint: String = "Search",
        onSearch: (String) -> Unit = {}
    ) {


        var text by remember {
            mutableStateOf("")
        }
        var isHintDisplayed by remember {
            mutableStateOf(hint != "")
        }

        Box(modifier = Modifier
            .fillMaxSize()
            .padding(10.dp),
            contentAlignment = Alignment.TopCenter

        ){

        Box(
            modifier = Modifier,

        ) {

            BasicTextField(

                value = text,
                onValueChange = {
                    text = it
                    onSearch(it)
                },
                maxLines = 1,


                textStyle = TextStyle(color = Color.Black),
                modifier = Modifier
                    .fillMaxWidth(0.95f)
                    .background(color = Color.LightGray, CircleShape,)
                    .padding(horizontal = 20.dp, vertical = 12.dp)
                    .onFocusChanged {
                        isHintDisplayed = it.isFocused != true
                    }

            )
            if (isHintDisplayed) {
                Text(
                    text = hint,
                    color = Color.Black,
                    modifier = Modifier.padding(horizontal = 20.dp, vertical = 12.dp)
                )
            }
        }


    }
    }








    @ExperimentalMaterialApi
    @Composable
    fun MovieList(

        navController: NavController,
        movies: MutableList<Movie>,
        onMovieCheckedChange: (Movie) -> Unit,

    ) {
        LazyRow {

            items(count = movies.size) { index ->
                val movie = movies[index]
                Movie(
                    navController = navController,
                    movie = movie,

                    onMovieCheckedChange = onMovieCheckedChange,


                )


            }
        }

    }




/*

    @ExperimentalMaterialApi
    @Preview
    @Composable
    fun MovieListPreview() {
        MovieList(
            navController = navController,
            movies = mutableListOf(
                Movie(
                    id = 1,
                    name = "Kermit",
                    isCheckedOff = false,
                    movieType = "Action",
                    overview = "None",
                    picture = R.drawable.iron_man_1,


                ),
                Movie(
                    id = 2,
                    name = "Kermit",
                    isCheckedOff = true,
                    movieType = "Action",
                    overview = "None",
                    picture = R.drawable.avengers_1

                ),
                Movie(
                    id = 3,
                    name = "Kermit",
                    isCheckedOff = true,
                    movieType = "Action",
                    overview = "None",
                    picture = R.drawable.puppy_love

                )
            ),
            onMovieCheckedChange = {},
            onMovieClick = {}
        )
    }
*/

    @Preview
    @Composable
    fun searchBarPreview() {
        searchBar(
            hint = "Search",
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        )
    }




