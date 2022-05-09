package com.company.tmdb.presentation.movie_detail.components

import android.graphics.Paint
import android.text.Layout
import androidx.compose.animation.Animatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Blue
import androidx.compose.ui.graphics.Color.Companion.Green
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.company.tmdb.R


import com.company.tmdb.presentation.Movie

@Composable
fun MovieUserScore(userScore: Double){

    CircularProgressBar(userScore)

    
}

@Composable
fun CircularProgressBar(
    userScore: Double,
    radius: Dp = 35.dp,
    color: Color = Color.Green,
    strokeWidth: Dp = 2.dp,
    animationDuration: Int = 3000,
    animationDelay: Int = 0
) {
    val percentage = userScore/100


    val currentPercentage = remember { androidx.compose.animation.core.Animatable(0f) }

    LaunchedEffect(percentage){
        currentPercentage.animateTo(
            percentage.toFloat(),
            animationSpec = tween(animationDuration,
                delayMillis = animationDelay
            )
        )
    }

    Row (modifier = Modifier
        .wrapContentWidth(unbounded = true)){



        Box(

            modifier = Modifier
                .size(radius * 2f),
            contentAlignment = Alignment.Center


        ) {
            Canvas(modifier = Modifier.size(radius * 1.3f)) {
                drawArc(
                    color = color,
                    -90f,
                    360 * currentPercentage.value,
                    useCenter = false,
                    style = Stroke(strokeWidth.toPx(), cap = StrokeCap.Round)
                )
            }
            var userScoreResult = (currentPercentage.value * 100).toInt()
            Text(
                text = "$userScoreResult%",
                color = Color.White,
                fontSize = 12.sp
            )

        }
        Box(
            modifier = Modifier
                .size(radius * 2f),
            contentAlignment = Alignment.Center
        ){
            Text(
                text = "User Score",
                color = Color.White,

                textAlign = TextAlign.Center,
                fontSize = 14.sp,
                fontWeight = FontWeight.Bold


            )

        }




    }


    




}


@Preview
@Composable
fun MovieUserScorePreview(){
    MovieUserScore(72.0)

}