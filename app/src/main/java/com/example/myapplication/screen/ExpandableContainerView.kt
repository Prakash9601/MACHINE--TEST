package com.example.myapplication.screen


import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import com.example.myapplication.R
import com.example.myapplication.model.Product


@Composable
fun ExpandableContainerView(
    title: String,
    onClickItem: () -> Unit,
    expanded: Boolean,
    products: ArrayList<Product>?
) {
    Box(
        modifier = Modifier
            .border(0.1.dp, Color.Black) // Adjust the border width and color as needed
            .background(colorResource(R.color.white))
    ) {
        Column {
            HeaderView(questionText = title, onClickItem = onClickItem)
            ExpandableView(isExpanded = expanded,products)
        }
    }

}