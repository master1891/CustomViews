package com.nels.master.customviews.ui.components.compounds

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.core.graphics.toColorInt
import com.nels.master.customviews.ui.components.CustomRadioButtonCanvas

@Composable
fun RadioCompound(modifier: Modifier = Modifier) {

    val numberRadios = (0..4).toMutableList()

    var indexSelected by rememberSaveable { mutableIntStateOf(0) }

    LazyColumn(
        modifier = modifier
    ) {
        itemsIndexed(numberRadios) { index, item ->
            //Selecciona el ultimo
            val selected = indexSelected == item

            CustomRadioButtonCanvas(
                colorSelected = Color("#A5A58D".toColorInt()),
                position = index,
                sizeRadioButton = 20.dp,
                isSelected = selected
            ) { position ->
                indexSelected = position
            }
        }
    }
}