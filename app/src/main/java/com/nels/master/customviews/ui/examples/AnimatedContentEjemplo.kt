package com.nels.master.customviews.ui.examples

import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.animation.togetherWith
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp


@Composable
fun AnimatedContentEjemplo(modifier: Modifier = Modifier){

    var contador by rememberSaveable { mutableStateOf(0) }


    Column(
        modifier = modifier
    ) {
        Button(onClick = {
            contador++
        }) {
            Text("Animate content de ejemplo")
        }
        Spacer(Modifier.height(20.dp))
        AnimatedContent(
            targetState = contador,
            transitionSpec = {
                // Animación de entrada: el nuevo número se desliza desde abajo
                slideInVertically(animationSpec = tween(durationMillis = 300)) { height -> height } +
                        fadeIn(animationSpec = tween(durationMillis = 300)) togetherWith
                        // Animación de salida: el número antiguo se desliza hacia arriba
                        slideOutVertically(animationSpec = tween(durationMillis = 300)) { height -> -height } +
                        fadeOut(animationSpec = tween(durationMillis = 300))

            },
            label = "Animacion avanzada"
        ) { targetCount ->

            Box(modifier = Modifier.fillMaxWidth().height(50.dp).background(Color.LightGray)) {
                Text(text = "Número: $targetCount")
            }
        }
    }


}
