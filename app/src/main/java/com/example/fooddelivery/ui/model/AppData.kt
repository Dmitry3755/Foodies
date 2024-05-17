package com.example.fooddelivery.ui.model

import com.example.domain.entities.BasketItem
import com.example.domain.entities.Product

object AppData {
    var productsFilterList: MutableList<Product> = mutableListOf()
    var basketList: MutableList<BasketItem> = mutableListOf()
}