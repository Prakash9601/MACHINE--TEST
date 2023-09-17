package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.core.content.ContextCompat
import androidx.lifecycle.ViewModelProvider
import com.example.myapplication.model.Example
import com.example.myapplication.model.ExpandableListViewModelFactory
import com.example.myapplication.screen.MainScreen
import com.example.myapplication.ui.theme.MACHINETESTTheme
import com.example.myapplication.utils.AppDatabase

class MainActivity : ComponentActivity() {
    private var viewModel:ExpandableListViewModel?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
       val database = AppDatabase.getInstance(applicationContext)
        val productDao = database.ProductDao()
        val viewModelFactory = ExpandableListViewModelFactory(productDao)
         viewModel = ViewModelProvider(
            this,
            viewModelFactory
        )[ExpandableListViewModel::class.java]


        setContent {
            MACHINETESTTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                   MainScreen(viewModel = viewModel!!)
                }
            }
        }
    }
}

