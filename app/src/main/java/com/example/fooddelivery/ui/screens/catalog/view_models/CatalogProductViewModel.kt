package com.example.fooddelivery.ui.screens.catalog.view_models

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.entities.BasketItem
import com.example.domain.entities.Product
import com.example.domain.network.products.use_case.GetAllProductsUseCase
import com.example.domain.utils.LoadingStatus
import com.example.domain.entities.AppData
import com.example.fooddelivery.ui.base.BaseProductViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class CatalogProductViewModel @Inject constructor(
    private val getAllProductsUseCase: GetAllProductsUseCase,
) : BaseProductViewModel() {

    var internalProductList: MutableLiveData<List<Product>> = MutableLiveData()
    var productList: LiveData<List<Product>> = internalProductList

    fun getAllProducts() {
        getAllProductsUseCase.invoke().flowOn(Dispatchers.IO).onEach {
            if (it is LoadingStatus.Success) {
                internalProductList.postValue(it.result)
            }
        }.launchIn(viewModelScope)
    }

    fun getBasketList(): MutableList<BasketItem> {
        return AppData.basketList.value!!
    }

    fun filterList(selectedCategoryId: Int) {
        AppData.productsFilterList =
            internalProductList.value!!.filter { it.categoryId == selectedCategoryId }
                .toMutableList()
    }

    fun addProductOnBasket(product: Product, addNew: Boolean) {
        if (addNew) {
            AppData.basketList.value!!.add(BasketItem(MutableLiveData(1), product))
            AppData.basketList.value = AppData.basketList.value
        } else {
            AppData.basketList.value!!.forEach {
                if (it.product == product) {
                    it.count.value = it.count.value!! + 1
                }
            }
        }
        sumAllBasketItem()
    }

    fun reduceProductOnBasket(product: Product) {
        AppData.basketList.value!!.forEach {
            if (it.product == product && it.count.value!! <= 1) {
                var a= AppData.basketList.value!!.indexOf(AppData.basketList.value!!.first { basketItem: BasketItem -> basketItem.product == product })
                AppData.basketList.value!![a].count.value = 0
            } else if (it.product == product && it.count.value!! > 1) {
                it.count.value = it.count.value!! - 1
            }
        }
        sumAllBasketItem()
    }

    private fun sumAllBasketItem() {
        var sum = 0
        for (item in AppData.basketList.value!!) {
            sum += item.count.value!! * item.product!!.priceCurrent.toInt()
        }
        AppData.currentPrice.postValue(sum)
    }
}