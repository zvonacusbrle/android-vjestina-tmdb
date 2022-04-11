package com.company.tmdb.ui.theme

import androidx.compose.foundation.layout.RowScope
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.company.tmdb.ui.theme.theme.BottomNavGraph


@Composable
fun Main(){
    val navController = rememberNavController()
    
    Scaffold(
        bottomBar = {BottomBar(navController = navController)}
    ) {
        BottomNavGraph(navController = navController)
    }
}

@Composable
fun BottomBar(navController: NavHostController){
    val screens = listOf(
        BottomBarScreen.Home,
        BottomBarScreen.Favorite
    )
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination

    BottomNavigation(
        backgroundColor = Color.White,
        elevation = 5.dp
    ) {
        screens.forEach{screen ->
            if (currentDestination != null) {
                AddItem(
                    screen = screen ,
                    currentDestination = currentDestination,
                    navController = navController
                )
            }
        }
    }

}

@Composable
fun RowScope.AddItem(
    screen: BottomBarScreen,
    currentDestination: NavDestination,
    navController: NavHostController
){
    BottomNavigationItem(
        label = {
            Text(text = screen.title)
    },
        icon = {
            Icon(
                imageVector = screen.icon,
                contentDescription = "Screen icon"
            )
        },
        selected = currentDestination.hierarchy.any{
            it.route == screen.route
        } == true,
        onClick = {
            navController.navigate(screen.route)
        }
    )

        


}