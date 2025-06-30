package com.nels.master.customviews.ui.examples

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun AnimacionesBasicasEjemplo() {

    var pivot by remember { mutableStateOf(false) }
    val sizeState by animateDpAsState(if (pivot) 100.dp else 50.dp)
    val colorState by animateColorAsState(if (pivot) Color.Blue else Color.Red)

    Column(
        modifier = Modifier.fillMaxSize()
    ) {

        Button(onClick = {
            pivot = !pivot
        }) {
            Text("Con animacion")
        }


        Text("Haz clic en cualquier lugar para animar el Box")
        Spacer(modifier = Modifier.height(20.dp))
        Box(
            modifier = Modifier
                .size(sizeState)
                .background(colorState)
        )
    }

}



