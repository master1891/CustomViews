package com.nels.master.customviews.ui.components

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.core.graphics.toColorInt
import kotlin.math.min

@Composable
fun CustomRadioButtonCanvas(
    position: Int,
    sizeRadioButton: Dp = 70.dp,
    modifier: Modifier = Modifier,
    isSelected: Boolean,
    color: Color = Color("#CB997E".toColorInt()),
    colorSelected: Color = Color("#DDBEA9".toColorInt()),
    colorUnselected: Color = Color("#FFE8D6".toColorInt()),
    callbackSelected:(Int)-> Unit
) {


    Canvas(
        modifier = modifier
            .size(sizeRadioButton)
            .clip(CircleShape)
            .clickable {
                callbackSelected(position)
            }
    ) {

        //Dibuja un circulo
        val maxWidth = size.width
        val maxHeight = size.height

        val minDiameter = min(maxWidth, maxHeight)
        val finalradius = minDiameter / 2

        val centerRadius = Offset(maxWidth / 2, maxHeight / 2)
        drawCircle(color, finalradius, centerRadius)

        //Segundo circulo interno
        val radioInterno = finalradius * .5f
        drawCircle(if (isSelected) colorSelected else colorUnselected, radioInterno, centerRadius)


    }

}