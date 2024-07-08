package com.example.lab2.ASM1.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import com.example.lab2.ASM1.model.Category
import com.example.lab2.ASM1.model.Product
import com.example.lab2.ASM1.network.RetrofitClient

class CategoryViewModel : ViewModel() {
    var categories by mutableStateOf<List<Category>>(emptyList())
        private set
    var products by mutableStateOf<List<Product>>(emptyList())
        private set

    init {
        fetchCategories()

    }

    private fun fetchCategories() {
        viewModelScope.launch {
            try {
                val response = RetrofitClient.apiService.getCategories()
                categories = response
                Log.d("CategoryViewModel", "Categories loaded successfully: $categories")
            } catch (e: Exception) {
                // Handle error
                Log.e("CategoryViewModel", "Failed to load categories: ${e.message}", e)
            }
        }
    }

suspend fun fetchProductsForCategory(categoryID: Int) {
    try {
        val response = RetrofitClient.apiService.getProductsForCategory(categoryID)
        products = response
        Log.d("ViewModel", "Received products: $products")
    } catch (e: Exception) {
        Log.e("ViewModel", "Failed to load products: ${e.message}")
    }
}
    
}

