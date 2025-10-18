package com.example.kuali_app.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.kuali_app.api.RetrofitInstance
import com.example.kuali_app.models.Product
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch


class ProductViewModel: ViewModel() {
    private val _products = MutableStateFlow<List<Product>>(emptyList())
    val products = _products.asStateFlow()
    val categories = listOf("beverages","fruits","meats","frozen-foods")

    init {
        viewModelScope.launch {
            try{
                val allProducts = mutableListOf<Product>()
                for (cat in categories){
                    val response = RetrofitInstance.api.getProducts(category = cat)
                    allProducts += response.products
                }
                _products.value = allProducts
            } catch(e: Exception){
                Log.e("OpenFoodFacts","Error: ${e.message}")
            }

        }
    }
}