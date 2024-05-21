package com.example.fooddelivery.ui.screens.basket.view_models

import androidx.lifecycle.ViewModel
import com.example.domain.entities.AppData
import com.example.domain.entities.BasketItem
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class BasketViewModel @Inject constructor() : ViewModel() {

    fun getBasket(): MutableList<BasketItem> {
        return AppData.basketList.value!!
    }

    fun sumAllBasketItem() {
        var sum = 0
        for (item in AppData.basketList.value!!) {
            sum += item.count.value!! * item.product!!.priceCurrent.toInt()
        }
        AppData.currentPrice.postValue(sum)
    }

}