package com.nels.master.customviews.ui.examples

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
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
    var esGrande by remember { mutableStateOf(false) }
    val tamano by animateDpAsState(if (esGrande) 150.dp else 50.dp, label = "TamanoBox")
    val color by animateColorAsState(if (esGrande) Color.Red else Color.Blue, label = "ColorBox")

    Column(
        modifier = Modifier.fillMaxSize()
            .clickable { esGrande = !esGrande } // Toggle al hacer clic en la columna
    ) {
        Text("Haz clic en cualquier lugar para animar el Box")
        Spacer(modifier = Modifier.height(20.dp))
        Box(
            modifier = Modifier
                .size(tamano)
                .background(color)
                .animateContentSize() // Anima los cambios de tamaño
        )
    }
}