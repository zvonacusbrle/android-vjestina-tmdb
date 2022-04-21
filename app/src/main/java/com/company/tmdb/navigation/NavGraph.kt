package com.company.tmdb.ui.theme

import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.Composable

import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.company.tmdb.navigation.homeNavGraph

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