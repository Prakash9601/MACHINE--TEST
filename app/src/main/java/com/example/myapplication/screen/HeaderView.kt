package com.example.myapplication.screen


import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.KeyboardArrowDown
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun HeaderView(questionText: String, onClickItem: () -> Unit) {
    var isRotated by remember { mutableStateOf(false) }

    Box(
        modifier = Modifier
            .background(Color.White)
            .clickable(
                indication = null,
                interactionSource = remember { MutableInteractionSource() },
                onClick = {
                    isRotated = !isRotated // Toggle the rotation state on click
                    onClickItem()
                }
            )
            .padding(15.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(4.dp)
        ) {
            Text(
                modifier = Modifier.weight(5F),
                text = questionText,
                fontSize = 17.sp,
                color = Color.Black,
            )
            Icon(
                modifier = Modifier
                    .size(25.dp)
                    .rotate(if (isRotated) 360f else -90f), // Rotate 90 degrees when isRotated is true
                tint = Color.Black,
                imageVector = Icons.Rounded.KeyboardArrowDown,
                contentDescription = null,
            )
        }
    }
}