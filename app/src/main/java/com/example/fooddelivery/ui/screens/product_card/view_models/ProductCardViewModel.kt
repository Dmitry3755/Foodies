package com.example.fooddelivery.ui.screens.product_card.view_models

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.domain.entities.BasketItem
import com.example.domain.entities.Product
import com.example.domain.entities.AppData
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ProductCardViewModel @Inject constructor() : ViewModel() {

    fun getProductsFilterList(): MutableList<Product> {
        return AppData.productsFilterList
    }

    fun getCurrentProduct(id: Int): Product {
        return getProductsFilterList().first { product: Product -> product.id == id }
    }

    fun addProductOnBasket(product: Product) {
        var add = 0
        if (AppData.basketList.value!!.isNotEmpty()) {
            AppData.basketList.value!!.forEach {
                if (it.product == product) {
                    it.count.postValue(it.count.value!! + 1)
                    add += 1
                }
            }
            if (add == 0) {
                AppData.basketList.value!!.add(BasketItem(MutableLiveData(1), product))
                AppData.basketList.postValue(AppData.basketList.value)
            }
        } else {
            AppData.basketList.value!!.add(BasketItem(MutableLiveData(1), product))
            AppData.basketList.postValue(AppData.basketList.value)
        }
    }
}