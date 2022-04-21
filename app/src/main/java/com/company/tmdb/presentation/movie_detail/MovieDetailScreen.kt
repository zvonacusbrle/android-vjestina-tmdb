package com.company.tmdb.presentation.theme

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavController
import com.company.tmdb.presentation.Movie
import com.company.tmdb.presentation.movie_detail.components.MovieUserScore


@Composable
fun MovieDetaliScreen(navController: NavController, movie: Movie){

    Box(
        modifier = Modifier
            .background(backgroundColorApp)
            .fillMaxSize()

    ){
        Column() {

            Scaffold(
                topBar = { TopAppBarCompose(navController = navController) },
                content = {
                        topImageDetails(movie)
                    

                        }

                    )


                }





        }
    }

@Composable
fun topImageDetails(movie: Movie) {
    Box(

        content = {
            Image(
                painter = painterResource(id = movie.picture),
                contentDescription = "",
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(0.6f),

                contentScale = ContentScale.FillBounds

            )
            Column(
                modifier = Modifier,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                MovieUserScore(userScore = movie.userScore)
            }

        }
    )
}




