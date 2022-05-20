@file:Suppress("PreviewAnnotationInFunctionWithParameters")

package com.company.tmdb.presentation.theme

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
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
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
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
import com.company.tmdb.navigation.Screen
import com.company.tmdb.presentation.home.HomeViewModel
import com.company.tmdb.ui.theme.BottomNavGraph


@Composable
fun Main() {
    val navController = rememberNavController()


    val currentRoute = navController
        .currentBackStackEntryFlow
        .collectAsState(initial = navController.currentBackStackEntry)

    val showBottomBar = when (currentRoute.value?.destination?.route){
        Screen.Details.route -> false
        else -> true
    }

    if (showBottomBar){
        Scaffold(
            bottomBar = {BottomBar(navController = navController)},
        ) {
            BottomNavGraph(navController = navController)
        }
    } else{
        Scaffold(

        ) {
            BottomNavGraph(navController = navController)
        }
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
                modifier = Modifier.fillMaxWidth()
                    .border(2.dp, color = Color.White, shape = RectangleShape)
                    ,



                title = {
                    Box(
                        modifier = Modifier.fillMaxWidth()
                            .border(2.dp, color = Color.Yellow, shape = RectangleShape),
                       contentAlignment = Alignment.TopStart
                    ){
                        Image(
                            painterResource(
                                id = R.drawable.tmdb_logo
                            ),
                            "Logo picture",
                            modifier = Modifier
                                .size(130.dp)

                                .border(2.dp, color = Color.Green, shape = RectangleShape),


                            )
                    }


                },


                backgroundColor = Color(0xFF0B253F),
                navigationIcon = {
                    IconButton(onClick = {
                        navController.navigateUp()
                    },
                        modifier = Modifier.border(2.dp, color = Color.Red, shape = RectangleShape)
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

