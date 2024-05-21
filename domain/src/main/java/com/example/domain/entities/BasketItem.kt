package com.example.domain.entities

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

data class BasketItem(
    var count: MutableLiveData<Int>,
    var product: Product?
)