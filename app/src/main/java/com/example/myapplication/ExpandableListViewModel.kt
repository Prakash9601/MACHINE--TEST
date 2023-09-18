package com.example.myapplication

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapplication.api.MachineTestRetrofit
import com.example.myapplication.model.Category
import com.example.myapplication.model.Example
import com.example.myapplication.model.Product
import com.example.myapplication.model.ProductDao
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.filterNotNull
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn


class ExpandableListViewModel(val productDao: ProductDao?) : ViewModel() {
    // Replace with your Retrofit service
    var apiService: MachineTestRetrofit = MachineTestRetrofit.create()


    private val itemIdsList = MutableStateFlow(listOf<Int>())
    val itemIds: StateFlow<List<Int>> get() = itemIdsList

    val allCategories: LiveData<List<Category?>>? = productDao?.getAllCategory()



    init {
        getData()
    }



    private fun getData() {
        apiService.getProduct()?.enqueue(object : Callback<Example?> {
            override fun onResponse(call: Call<Example?>, response: Response<Example?>) {
                if (response.isSuccessful) {
                    val categories = response.body()?.categories ?: emptyList()
                    viewModelScope.launch{
                        if(response.body()?.categories?.size != allCategories?.value?.size )
                        insertCategories(categories)
                    }
                }
            }
            override fun onFailure(call: Call<Example?>, t: Throwable) {
                // Handle failure here
            }
        })
    }



    fun onItemClicked(itemId: Int) {
        itemIdsList.value = itemIdsList.value.toMutableList().also { list ->
            if (list.contains(itemId)) {
                list.remove(itemId)
            } else {
                list.add(itemId)
            }
        }
    }

    suspend fun insertCategories(categories: List<Example.Category>) {
        val categoryDao = productDao // Assuming productDao is non-null
        if (categories.isNotEmpty()) {
            for (categoryItem in categories) {
                val category = Category()
                category.title = categoryItem.title
                category.product = categoryItem.products as? ArrayList<Product>
                val categories2 = listOf(category)
                categoryDao?.insertCategories(categories2)
            }
        }
    }
}
