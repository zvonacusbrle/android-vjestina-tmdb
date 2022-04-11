package com.company.tmdb.ui.theme


import android.icu.text.CaseMap
import android.util.Log
import android.widget.ToggleButton
import androidx.compose.foundation.*
import androidx.compose.foundation.gestures.FlingBehavior
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField

import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.materialIcon

import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.focus.FocusState
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Outline
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue

import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

import com.company.tmdb.R
import com.company.tmdb.ui.theme.theme.Movie

import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.rememberPagerState
import kotlinx.coroutines.selects.select
import java.lang.reflect.Array.set

@OptIn(ExperimentalPagerApi::class, ExperimentalMaterialApi::class)
@Composable
fun HomeScreen () {
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
                    isCheckedOff = false,
                    movieType = "Action",
                    overview = "None",
                    picture = R.drawable.puppy_love

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
                    picture = R.drawable.jungle_beat

                ),

                Movie(
                    id = 2,
                    name = "Kermit",
                    isCheckedOff = true,
                    movieType = "Action",
                    overview = "None",
                    picture = R.drawable.jungle_beat

                ),
                Movie(
                    id = 3,
                    name = "Kermit",
                    isCheckedOff = false,
                    movieType = "Action",
                    overview = "None",
                    picture = R.drawable.jungle_beat

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
                    picture = R.drawable.avengers_1

                ),

                Movie(
                    id = 2,
                    name = "Kermit",
                    isCheckedOff = true,
                    movieType = "Action",
                    overview = "None",
                    picture = R.drawable.jungle_beat

                ),
                Movie(
                    id = 3,
                    name = "Kermit",
                    isCheckedOff = false,
                    movieType = "Action",
                    overview = "None",
                    picture = R.drawable.puppy_love

                ),
                Movie(
                    id = 4,
                    name = "Kermit",
                    isCheckedOff = false,
                    movieType = "Action",
                    overview = "None",
                    picture = R.drawable.jungle_beat

                )
            )
        )
    }


    val scrollState = rememberScrollState()
    val navController = rememberNavController()


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
                            .verticalScroll(scrollState)

                    ) {
                        searchBar()
                        sectionTitle("What's up")



                        whatsUpToolBar()
                        Spacer(modifier = Modifier.height(4.dp))

                        if (movies.isNotEmpty()) {

                            MovieList(

                                movies,
                                onMovieCheckedChange = { updatedMovie ->

                                    val index = movies.indexOfFirst { it.id == updatedMovie.id }
                                    movies = movies.toMutableList().apply { set(index, updatedMovie) }
                                },
                                onMovieClick = {

                                }

                            )
                        }

                        Text(
                            text = "Now playing",
                            fontSize = 20.sp,
                            fontWeight = FontWeight.Bold,
                            modifier = Modifier
                                .padding(5.dp)
                        )

                        if (popularMovies.isNotEmpty()) {

                            MovieList(

                                popularMovies,
                                onMovieCheckedChange = { updatedMovie ->

                                    val index = popularMovies.indexOfFirst { it.id == updatedMovie.id }
                                    popularMovies = popularMovies.toMutableList().apply { set(index, updatedMovie) }
                                },
                                onMovieClick = {

                                }

                            )
                        }

                        Text(
                            text = "Upcoming",
                            fontSize = 20.sp,
                            fontWeight = FontWeight.Bold,
                            modifier = Modifier
                                .padding(5.dp)
                        )

                        if (upcomingMovies.isNotEmpty()) {

                            MovieList(

                                upcomingMovies,
                                onMovieCheckedChange = { updatedMovie ->

                                    val index = upcomingMovies.indexOfFirst { it.id == updatedMovie.id }
                                    upcomingMovies = upcomingMovies.toMutableList().apply { set(index, updatedMovie) }
                                },
                                onMovieClick = {

                                }

                            )
                        }

                        if (upcomingMovies.isNotEmpty()) {

                            MovieList(

                                upcomingMovies,
                                onMovieCheckedChange = { updatedMovie ->

                                    val index = upcomingMovies.indexOfFirst { it.id == updatedMovie.id }
                                    upcomingMovies = upcomingMovies.toMutableList().apply { set(index, updatedMovie) }
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

    /*




    Column(
        modifier = Modifier
            .verticalScroll(scrollState)

        ) {


        Spacer(modifier = Modifier
            .height(115.dp))
        searchBar()
        sectionTitle("What's up")



        whatsUpToolBar()
        Spacer(modifier = Modifier.height(4.dp))

        if (movies.isNotEmpty()) {

            MovieList(

                movies,
                onMovieCheckedChange = { updatedMovie ->

                    val index = movies.indexOfFirst { it.id == updatedMovie.id }
                    movies = movies.toMutableList().apply { set(index, updatedMovie) }
                },
                onMovieClick = {

                }

            )
        }

        Text(
            text = "Now playing",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .padding(5.dp)
        )

        if (popularMovies.isNotEmpty()) {

            MovieList(

                popularMovies,
                onMovieCheckedChange = { updatedMovie ->

                    val index = popularMovies.indexOfFirst { it.id == updatedMovie.id }
                    popularMovies = popularMovies.toMutableList().apply { set(index, updatedMovie) }
                },
                onMovieClick = {

                }

            )
        }

        Text(
            text = "Upcoming",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .padding(5.dp)
        )

        if (upcomingMovies.isNotEmpty()) {

            MovieList(

                upcomingMovies,
                onMovieCheckedChange = { updatedMovie ->

                    val index = upcomingMovies.indexOfFirst { it.id == updatedMovie.id }
                    upcomingMovies = upcomingMovies.toMutableList().apply { set(index, updatedMovie) }
                },
                onMovieClick = {

                }

            )
        }

        if (upcomingMovies.isNotEmpty()) {

            MovieList(

                upcomingMovies,
                onMovieCheckedChange = { updatedMovie ->

                    val index = upcomingMovies.indexOfFirst { it.id == updatedMovie.id }
                    upcomingMovies = upcomingMovies.toMutableList().apply { set(index, updatedMovie) }
                },
                onMovieClick = {

                }

            )
        }




    }*/





   
    





}

fun popularMoviesSection(movies: List<Movie>) {
    TODO("Not yet implemented")
}








@Composable
fun sectionTitle(titleName: String) {
    Column() {
        Text(
            text = titleName,
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,

            modifier = Modifier
                .padding(5.dp)
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
                .fillMaxWidth()
                .wrapContentHeight(),
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
           /* Icon(
                imageVector = Icons.Default.Search,
                contentDescription = "Search icon"
            )*/

            BasicTextField(

                value = text,
                onValueChange = {
                    text = it
                    onSearch(it)
                },
                maxLines = 1,


                textStyle = TextStyle(color = Color.Black),
                modifier = Modifier
                    .fillMaxWidth(0.9f)
                    .shadow(5.dp, CircleShape)
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





    @Composable
    fun TopAppBarCompose() {
        TopAppBar(
            title = {
                Box(modifier = Modifier.fillMaxWidth()) {
                    Image(
                        painterResource(
                            id = R.drawable.tmdb_logo
                        ),
                        "Logo picture",
                        modifier = Modifier
                            .size(130.dp)
                            .align(Alignment.Center)
                    )
                }
            },
            backgroundColor = Color(0xFF0B253F)


        )


    }


    @ExperimentalMaterialApi
    @Composable
    fun MovieList(
        movies: MutableList<Movie>,
        onMovieCheckedChange: (Movie) -> Unit,
        onMovieClick: (Movie) -> Unit
    ) {
        LazyRow {
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


    //NE radi R.string.homeScreen
    @Composable
    fun Navigation(navController: NavHostController){
        NavHost(navController = navController, startDestination = "HomeScreen")
        {
            composable("HomeScreen"){
                HomeScreen()
            }
            composable("FavoriteScreen"){
                FavoriteScreen()
            }
        }
    }


    @ExperimentalMaterialApi
    @Preview
    @Composable
    fun MovieListPreview() {
        MovieList(
            movies = mutableListOf(
                Movie(
                    id = 1,
                    name = "Kermit",
                    isCheckedOff = false,
                    movieType = "Action",
                    overview = "None",
                    picture = R.drawable.iron_man_1

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




