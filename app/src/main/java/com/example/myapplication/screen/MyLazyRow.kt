package com.example.myapplication.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberImagePainter
import com.example.myapplication.ProductDetails
import com.example.myapplication.model.Product




@Composable
fun MyLazyRow(products: ArrayList<Product>?) {
    val mContext= LocalContext.current
    LazyRow(
        modifier = Modifier
            .fillMaxWidth()
            .height(200.dp)
    ) {
        items(products?.size ?: 0) { item ->
            val image = rememberImagePainter(
                data = products?.get(item)?.imageUrl,
                builder = {
                    crossfade(true)
                }
            )

            Card(
                modifier = Modifier
                    .width(150.dp)
                    .padding(8.dp)
                    .clickable {
                        val intent = ProductDetails.newIntent(mContext, products?.get(item)?.title, products?.get(item)?.price.toString(), products?.get(item)?.description,products?.get(item)?.imageUrl)
                        mContext.startActivity(intent)
                    },
                shape = RoundedCornerShape(5.dp),
                elevation = CardDefaults.cardElevation(
                    defaultElevation = 10.dp
                )
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(8.dp),
                    horizontalAlignment = Alignment.Start
                ) {
                    Image(
                        painter = image,
                        contentDescription = null,
                        modifier = Modifier
                            .size(120.dp)
                            .padding(8.dp)
                    )
                    Text(
                        text = products?.get(item)?.title.toString(),
                        fontSize = 18.sp,
                        color = Color.Black,
                        textAlign = TextAlign.Start,
                        fontWeight = FontWeight.Bold
                    )
                    Text(
                        text = "₹"+products?.get(item)?.price.toString(),
                        fontSize = 14.sp,
                        color = Color.Black,
                        textAlign = TextAlign.Start
                    )
                }
            }
        }
    }
}

