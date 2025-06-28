package com.nels.master.customviews.ui.examples


import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier

import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp


@Preview(showBackground = true, showSystemUi = true)
@Composable
fun StateExample() {

    val contadorState = rememberSaveable { mutableIntStateOf(0) }
    var contador2 by rememberSaveable { mutableIntStateOf(0) }

    Column {
        Button(onClick = {
            contador2++
        }) {
            Text("Incrementa")
        }

        Spacer(Modifier.height(30.dp))

        Button(onClick = {
            contador2--
        }) {
            Text("Decrementar")
        }

        Text("El valor actual es: $contador2")

    }

}