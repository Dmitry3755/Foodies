package com.example.fooddelivery.ui.base

import androidx.lifecycle.ViewModel
import com.example.domain.entities.AppData
import com.example.domain.entities.Product


abstract class BaseProductViewModel() : ViewModel() {

    fun getProductsFilterList() = AppData.productsFilterList

    fun getCurrentProduct(id: Int) = getProductsFilterList().first { product: Product -> product.id == id }

}