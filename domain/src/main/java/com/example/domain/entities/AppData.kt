package com.example.domain.entities

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.domain.entities.BasketItem
import com.example.domain.entities.Product

object AppData {
    var productsFilterList: MutableList<Product> = mutableListOf()
    var basketList: MutableLiveData<MutableList<BasketItem>> = MutableLiveData(mutableListOf())
    var currentPrice: MutableLiveData<Int> = MutableLiveData(0)
}