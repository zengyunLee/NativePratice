package com.aaron.hulanative.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class HomeViewModel : ViewModel() {

//    private val _fruitList =
    val fruitList = MutableLiveData(listOf(1,2,3,4,5,6))
}