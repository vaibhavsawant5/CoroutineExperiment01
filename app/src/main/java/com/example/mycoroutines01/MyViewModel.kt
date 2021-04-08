package com.example.mycoroutines01

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MyViewModel : ViewModel() {

    init {
        viewModelScope.launch(Dispatchers.IO) {

        }
    }
}