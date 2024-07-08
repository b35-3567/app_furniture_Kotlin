package com.example.lab2.ASM1.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.lab2.ASM1.model.Product
import com.example.lab2.ASM1.network.RetrofitClient
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class ProductViewModel : ViewModel() {
    private val _product = MutableStateFlow<Product?>(null)
    val product: StateFlow<Product?> = _product

    fun fetchProduct(productId: Int) {
        viewModelScope.launch {
            try {
                Log.d("ProductViewModel", "Fetching product with ID: $productId")
                val fetchedProducts = RetrofitClient.apiService.getProduct(productId)
                if (fetchedProducts.isNotEmpty()) {
                    _product.value = fetchedProducts[0] // Lấy sản phẩm đầu tiên từ danh sách
                } else {
                    Log.e("ProductViewModel", "No product found with ID: $productId")
                }
                Log.d("ProductViewModel", "Fetched product: ${fetchedProducts[0]}")
            } catch (e: Exception) {
                Log.e("ProductViewModel", "Error fetching product", e)
            }
        }
    }
}