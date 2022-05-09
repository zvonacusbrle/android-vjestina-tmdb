package com.company.tmdb.presentation.theme

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.company.tmdb.presentation.Movie
import com.company.tmdb.presentation.movie_detail.components.FavoriteButtonIcon
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
                    .fillMaxHeight(0.5f),
                contentScale = ContentScale.FillBounds

            )
            Column(modifier = Modifier
                .align(Alignment.BottomStart)
                .padding(start = 15.dp),

            ) {
                    MovieUserScore(userScore = movie.userScore)
                    Row(
                        modifier = Modifier
                            .fillMaxWidth(0.5f)
                    ) {
                        Text(

                            text = "${movie.name} (2008)",

                            fontSize = 20.sp,
                            color = Color.White,
                            textAlign = TextAlign.Center,
                            fontWeight = FontWeight.Bold
                        )


                    }

                Text(
                    text = "05/02/2008 (US)",

                    color = Color.White,
                )
                Text(
                    text = "Action, Science 2h 6m",
                    color = Color.White,
                )
                Spacer(modifier = Modifier.height(10.dp))
                FavoriteButtonIcon(movie)
                Spacer(modifier = Modifier.height(10.dp))
                
            }



        }
    )
}




