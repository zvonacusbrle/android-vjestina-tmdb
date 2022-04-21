package com.company.tmdb.navigation

import androidx.compose.material.ExperimentalMaterialApi
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import com.company.tmdb.presentation.Movie
import com.company.tmdb.presentation.theme.FavoriteScreen
import com.company.tmdb.presentation.theme.HomeScreen
import com.company.tmdb.presentation.theme.MovieDetaliScreen

@OptIn(ExperimentalMaterialApi::class)

fun NavGraphBuilder.favoriteNavGraph(
    navController: NavHostController
){
    navigation(
        startDestination = Screen.Favorite.route,
        route =  "favorite"

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