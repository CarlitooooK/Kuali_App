package com.example.kuali_app.models

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class MainViewModel: ViewModel() {
    var selectedIndex by mutableStateOf(0)
        private set

    fun updateIndex(newIndex: Int){
        selectedIndex =newIndex
    }
}