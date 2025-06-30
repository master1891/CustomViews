package com.nels.master.customviews.ui.examples

import androidx.compose.animation.Crossfade
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
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
fun CrossfadeEjemplo(modifier: Modifier = Modifier){

    var mostrarContenidoA by rememberSaveable { mutableStateOf(true) }

    Column(
        modifier = modifier
    ) {
        Button(onClick = {
            mostrarContenidoA = !mostrarContenidoA
        }) {
            Text("Haz clic para cambiar el contenido de Crossfade")
        }
        Spacer(Modifier.height(16.dp))

        Crossfade(
            targetState = mostrarContenidoA,
            label = "Corossfade ejemplo"
        ) { target ->
            if (target){
                Box(modifier = Modifier.size(100.dp).background(Color.Cyan)) {
                    Text("Contenido A")
                }
            }else{
                Box(modifier = Modifier.size(200.dp).background(Color.Green)) {
                    Text("Contenido B")
                }
            }
        }

    }



}