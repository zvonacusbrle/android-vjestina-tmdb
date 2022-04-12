package com.company.tmdb.ui.theme

import androidx.compose.foundation.layout.RowScope
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.company.tmdb.ui.theme.theme.BottomNavGraph


@Composable
fun Main(){
    val navController = rememberNavController()
    
    Scaffold(
        bottomBar = {BottomBar(navController = navController)},

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
    /*if(screen.title == "Favorite"){
        screen.icon =
    }*/
    BottomNavigationItem(
        label = {
            Text(text = screen.title)
    },
        icon = {
            if (screen.title == "Favorite"){
                Icon(
                    imageVector = Icons.Default.Favorite,
                    contentDescription = "Screen icon"
                )

            }
            Icon(
                imageVector = screen.icon,
                contentDescription = "Screen icon"
            )


        },
        selected = currentDestination.hierarchy.any{
            it.route == screen.route
        } == true,
        unselectedContentColor = LocalContentColor.current.copy(alpha = ContentAlpha.disabled),
        onClick = {
            navController.navigate(screen.route){
                popUpTo(navController.graph.findStartDestination().id)
                launchSingleTop = true
            }
        }
    )

        


}