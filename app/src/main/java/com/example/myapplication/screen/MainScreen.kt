package com.example.myapplication.screen

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.MutableLiveData
import com.example.myapplication.ExpandableListViewModel
import com.example.myapplication.model.Category


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen(viewModel: ExpandableListViewModel) {
    val itemIds by viewModel.itemIds.collectAsState()
    val dpItems =  viewModel.allCategories!!.observeAsState()
    Scaffold(
        topBar = { TopBar() }
    ) { padding ->  // We need to pass scaffold's inner padding to the content
        LazyColumn(modifier = Modifier.padding(padding),
            contentPadding = PaddingValues(5.dp)
        ) {
            items(dpItems.value?.size?:0){
             dpItems.value?.get(it)?.title?.let { it1 ->
                    ExpandableContainerView(
                        title = it1,
                        onClickItem = { viewModel.onItemClicked(it) },
                        expanded = itemIds.contains(it),
                        products = dpItems.value!![it]?.product
                    )
                }
            }
        }
    }
}