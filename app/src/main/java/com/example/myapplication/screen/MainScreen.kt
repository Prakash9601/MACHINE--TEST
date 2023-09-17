package com.example.myapplication.screen

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.myapplication.ExpandableListViewModel


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen(viewModel: ExpandableListViewModel) {
    val itemIds by viewModel.itemIds.collectAsState()
    val items by viewModel.items.collectAsState()



    Scaffold(
        topBar = { TopBar() }
    ) { padding ->  // We need to pass scaffold's inner padding to the content
        LazyColumn(modifier = Modifier.padding(padding),
            contentPadding = PaddingValues(5.dp)
        ) {
            items(items.size){
                items[it].title?.let { it1 ->
                    ExpandableContainerView(
                        title = it1,
                        onClickItem = { viewModel.onItemClicked(it) },
                        expanded = itemIds.contains(it),
                        products = items[it].products
                    )
                }
            }
        }
    }
}