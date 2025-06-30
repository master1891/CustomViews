package com.nels.master.customviews.ui.examples

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun AnimatedVisibilityEjemplo(modifier: Modifier = Modifier){

    var isVisible by rememberSaveable { mutableStateOf(true) }

    Column(
        modifier = modifier
    ) {

        Button(onClick = {
            isVisible = !isVisible
        }) {

            Text(
                modifier = Modifier.animateContentSize(),
               text =  if (isVisible) "Es visible" else "Mostrar texto"
            )
        }

        Spacer(Modifier.height(16.dp))
        //Note Esta es la parte importante
        AnimatedVisibility(
            visible = isVisible,
            enter = fadeIn(),
            exit = fadeOut()
        ) {
            Text("Este es el contenido que se va a mostar u oclultar")
        }

    }

}