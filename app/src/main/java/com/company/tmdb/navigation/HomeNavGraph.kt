package com.company.tmdb.navigation

import androidx.compose.material.ExperimentalMaterialApi
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import androidx.navigation.navigation
import com.company.tmdb.ui.theme.FavoriteScreen
import com.company.tmdb.ui.theme.HomeScreen
import com.company.tmdb.ui.theme.MovieDetaliScreen
import com.company.tmdb.ui.theme.Screen
import com.company.tmdb.ui.theme.theme.Movie

@OptIn(ExperimentalMaterialApi::class)
fun NavGraphBuilder.homeNavGraph(
    navController: NavController
){


    navigation(
        startDestination = Screen.Home.route,
        route =  "home"

    ){
        composable(route = Screen.Home.route){
            HomeScreen(navController = navController)
        }

        composable(route = Screen.Favorite.route){
            FavoriteScreen(navController = navController)
        }


        composable(route = Screen.Details.route){
            val movie = navController.previousBackStackEntry?.savedStateHandle?.get<Movie>("movie")

            movie?.let{
                MovieDetaliScreen(navController = navController, movie)
            }

        }
    }
}