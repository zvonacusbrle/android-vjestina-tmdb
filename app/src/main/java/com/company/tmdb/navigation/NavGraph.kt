package com.company.tmdb.ui.theme.theme

import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.Composable

import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import com.company.tmdb.navigation.favoriteNavGraph
import com.company.tmdb.navigation.homeNavGraph
import com.company.tmdb.ui.theme.Screen

import com.company.tmdb.ui.theme.FavoriteScreen
import com.company.tmdb.ui.theme.HomeScreen
import com.company.tmdb.ui.theme.MovieDetaliScreen

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun BottomNavGraph(
    navController: NavHostController
){
    NavHost(
        navController =navController,
        startDestination = "home",
        route = "root"
    ){
        homeNavGraph(navController = navController)
        //favoriteNavGraph(navController = navController)











    }
}