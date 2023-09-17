package com.example.myapplication

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberImagePainter
import com.example.myapplication.ui.theme.MACHINETESTTheme


class ProductDetails : ComponentActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        val title = intent.getStringExtra(EXTRA_TITLE)
        val price = intent.getStringExtra(EXTRA_PRICE)
        val description = intent.getStringExtra(EXTRA_DESCRIPTION)
        val imageUrl = intent.getStringExtra(EXTRA_DATA)

        setContent {
            MACHINETESTTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Greeting(title.toString(), price, description, imageUrl, this)
                }
            }
        }
    }


    companion object {
        private const val EXTRA_TITLE = "extra_title"
        private const val EXTRA_PRICE = "extra_price"
        private const val EXTRA_DESCRIPTION = "extra_description"
        private const val EXTRA_DATA = "extra_data"

        fun newIntent(
            context: Context,
            data: String?,
            price: String?,
            description: String?,
            imageUrl: String?
        ): Intent {
            val intent = Intent(context, ProductDetails::class.java)
            intent.putExtra(EXTRA_TITLE, data)
            intent.putExtra(EXTRA_PRICE, price)
            intent.putExtra(EXTRA_DESCRIPTION, description)
            intent.putExtra(EXTRA_DATA, imageUrl)
            return intent
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Greeting(
    title: String,
    price: String?,
    description: String?,
    imageUrl: String?,
    productDetails: ProductDetails
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        // Toolbar
        TopAppBar(
            navigationIcon = {
                IconButton(onClick = { productDetails.finish() }) {
                    Icon(imageVector = Icons.Default.ArrowBack, contentDescription = null)
                }
            },
            title = { Text("Product Details") },
            actions = {

            }
        )

        val image = rememberImagePainter(
            data = imageUrl,
            builder = {
                crossfade(true)
            }
        )

        // Image
        Image(
            painter = image, // Replace with your image resource
            contentDescription = null,
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight(),
            contentScale = ContentScale.Crop
        )

        Spacer(
            modifier = Modifier
                .height(10.dp) // You can adjust the height as needed
        )
        // Text Elements
        Text(
            text = title,
            fontSize = 18.sp,
            textAlign = TextAlign.Start,
            fontWeight = FontWeight.Bold
        )
        Spacer(
            modifier = Modifier
                .height(10.dp) // You can adjust the height as needed
        )
        Text(
            text = "₹" + price.toString(),
            fontSize = 14.sp,
            textAlign = TextAlign.Start
        )
        Spacer(
            modifier = Modifier
                .height(40.dp) // You can adjust the height as needed
        )

        Text(
            text = "₹" + description.toString(),
            fontSize = 14.sp,
            textAlign = TextAlign.Start
        )

        Spacer(
            modifier = Modifier
                .height(40.dp) // You can adjust the height as needed
        )

        // Button
        Button(
            onClick = {
                // Handle button click
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 16.dp)
        ) {
            Text("Add Card")
        }
    }
}

