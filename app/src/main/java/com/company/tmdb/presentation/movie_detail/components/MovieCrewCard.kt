package com.company.tmdb.presentation.movie_detail.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp


@Composable


fun MovieCrewCard(
    name: String= "John",
    position: String = "Malkovic" ){
    Box(
        modifier = Modifier
            .padding(10.dp)

            .background(Color.White),
        contentAlignment = Alignment.Center

    ) {
        Column(
            modifier = Modifier
                .padding(10.dp)
                .width(70.dp)
                .height(80.dp),


        ) {
            Text(text = name)

            Spacer(modifier = Modifier.height(5.dp))
            Text(text = position)
        }

    }
}


@Preview
@Composable
fun MovieCrewCardPreview(){
    MovieCrewCard()
}