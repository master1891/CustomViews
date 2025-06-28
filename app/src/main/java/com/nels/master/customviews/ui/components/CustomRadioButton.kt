package com.nels.master.customviews.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp

@Composable
fun CustomRadioButton(isChecked: Boolean, size: Dp, modifier: Modifier = Modifier) {

    var isChecked by rememberSaveable { mutableStateOf(isChecked) }

    Box(
        modifier = modifier
            .clip(CircleShape)
            .background(Color.Red)
            .size(size)
            .clickable {

            },
        contentAlignment = Alignment.Center
    ) {

        Box(
            modifier = Modifier
                .fillMaxSize(.6f)
                .clip(CircleShape)
                .then(
                    if (isChecked)
                        Modifier.background(Color.Yellow)
                    else
                        Modifier.background(Color.White)
                )
                .clickable {
                    isChecked = !isChecked
                },
            contentAlignment = Alignment.Center
        ) {

        }
    }

}