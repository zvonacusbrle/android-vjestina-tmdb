package com.company.tmdb.ui.theme

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavController
import com.company.tmdb.ui.theme.theme.Movie

@Composable
fun MovieDetaliScreen(navController: NavController, movie: Movie){

    Column() {
        
        
        Scaffold(
            modifier = Modifier.padding(),
            topBar = { TopAppBarCompose(navController) },
            content = {
                Text(text = movie.name
                    )
            }
        ) 
            

        

    }


}