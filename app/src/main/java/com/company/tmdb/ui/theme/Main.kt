@file:Suppress("PreviewAnnotationInFunctionWithParameters")

package com.company.tmdb.ui.theme

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.rounded.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.Center
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.company.tmdb.R
import com.company.tmdb.ui.theme.theme.BottomNavGraph


@Composable
fun Main(){
    val navController = rememberNavController()
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination


    
    Scaffold(


        bottomBar = {BottomBar(navController = navController)},


    ) {
        BottomNavGraph(navController = navController)
    }
}

@Composable
fun BottomBar(navController: NavHostController){
    val screens = listOf(
        Screen.Home,
        Screen.Favorite
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
    screen: Screen,
    currentDestination: NavDestination,
    navController: NavHostController


){
    BottomNavigationItem(
        label = {
            Text(text = screen.title)
    },
        icon = {
            if (currentDestination.route == Screen.Favorite.route){
                Screen.Favorite.icon = Icons.Default.Favorite
            }
            else{
                Screen.Favorite.icon = Icons.Default.FavoriteBorder
            }
            screen.icon?.let {
                Icon(
                    imageVector = it,
                    contentDescription = "Screen icon"
                )
            }


        },
        selected = currentDestination.hierarchy.any{
            it.route == screen.route
        } == true,
        unselectedContentColor = LocalContentColor.current.copy(alpha = ContentAlpha.disabled),
        onClick = {
            navController.navigate(screen.route){
                popUpTo(navController.graph.findStartDestination().id)
                launchSingleTop = true
                restoreState = true
            }
        }
    )

        


}

@Composable
fun TopAppBarCompose(navController: NavController) {
    val currentRoute = navController
        .currentBackStackEntryFlow
        .collectAsState(initial = navController.currentBackStackEntry)

    val showBackButton = when (currentRoute.value?.destination?.route){
        Screen.Home.route -> false
        Screen.Favorite.route -> false
        else -> true
    }
    if(showBackButton){
        TopAppBar(
            title = {
                Box(
                    modifier =
                    Modifier
                        .fillMaxWidth(),
                    contentAlignment = Alignment.CenterStart
                ) {
                    Column(modifier = Modifier.fillMaxWidth()) {
                        Image(
                            painterResource(
                                id = R.drawable.tmdb_logo
                            ),
                            "Logo picture",
                            modifier = Modifier
                                .size(130.dp)

                        )
                    }


                }
            },
            backgroundColor = Color(0xFF0B253F),
            navigationIcon = {
                IconButton(onClick = {
                    navController.navigateUp()
                }
                ) {
                    Icon(Icons.Rounded.ArrowBack, "Back arrow")
                }
            }

        )
    } else{
        TopAppBar(
            title = {
                Box(modifier = Modifier.fillMaxWidth()
                ) {
                    Image(
                        painterResource(
                            id = R.drawable.tmdb_logo
                        ),
                        "Logo picture",
                        modifier = Modifier
                            .size(130.dp)
                            .align(Alignment.TopCenter)
                    )
                }
            },
            backgroundColor = Color(0xFF0B253F)
        )

    }



}


