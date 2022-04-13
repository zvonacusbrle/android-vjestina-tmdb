package com.company.tmdb.ui.theme.theme

import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.Composable

import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.company.tmdb.ui.theme.BottomBarScreen
import com.company.tmdb.ui.theme.FavoriteScreen
import com.company.tmdb.ui.theme.HomeScreen

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun BottomNavGraph(navController: NavHostController){
    NavHost(
        navController =navController,
        startDestination = BottomBarScreen.Home.route
    ){
        composable(route = BottomBarScreen.Home.route){
            HomeScreen(navController = navController)
        }
        composable(route = BottomBarScreen.Favorite.route){
            FavoriteScreen()
        }

    }
}