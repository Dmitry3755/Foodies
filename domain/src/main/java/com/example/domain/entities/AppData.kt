package com.example.fooddelivery.ui.model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.domain.entities.BasketItem
import com.example.domain.entities.Product

object AppData {
    var productsFilterList: MutableList<Product> = mutableListOf()
    var basketList: MutableLiveData<MutableList<BasketItem>> = MutableLiveData(mutableListOf())
}