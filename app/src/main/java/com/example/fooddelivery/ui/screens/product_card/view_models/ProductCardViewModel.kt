package com.example.fooddelivery.ui.screens.product_card.view_models

import androidx.lifecycle.ViewModel
import com.example.domain.entities.BasketItem
import com.example.domain.entities.Product
import com.example.fooddelivery.ui.model.AppData
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlin.math.roundToInt

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
        if (AppData.basketList.isNotEmpty()) {
            for (basketProduct in AppData.basketList) {
                if (basketProduct.product == product) {
                    basketProduct.count += 1
                    add + 1
                }
            }
            if (add == 0) {
                AppData.basketList.add(BasketItem(1, product))
            }
        } else {
            AppData.basketList.add(BasketItem(1, product))
        }
    }
}