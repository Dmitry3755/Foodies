package com.example.fooddelivery.ui.screens.catalog.view_models

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.entities.BasketItem
import com.example.domain.entities.Product
import com.example.domain.network.products.use_case.GetAllProductsUseCase
import com.example.domain.utils.LoadingStatus
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class CatalogProductViewModel @Inject constructor(
    private val getAllProductsUseCase: GetAllProductsUseCase,
) : ViewModel() {

    var productList: MutableLiveData<List<Product>> = MutableLiveData()
    var basketList: MutableLiveData<MutableList<BasketItem>> = MutableLiveData(mutableListOf())
    var productsFilterList: MutableList<Product> = mutableListOf()


    fun getAllProducts() {
        getAllProductsUseCase.invoke().flowOn(Dispatchers.IO).onEach {
            if (it is LoadingStatus.Success) {
                productList.postValue(it.result)
            }
        }.launchIn(viewModelScope)
    }

    fun filterList(selectedCategoryId: Int) {
        productsFilterList =
            productList.value!!.filter { it.categoryId == selectedCategoryId }.toMutableList()
    }

    fun addProductOnBasket(product: Product) {
        if (basketList.value!!.size != 0) {
            for (basketList in basketList.value!!) {
                if (basketList.product == product) {
                    basketList.count += 1
                }
            }
        } else {
            basketList.postValue(mutableListOf(BasketItem(1, product)))
        }
    }

    fun reduceProductOnBasket(product: Product) {

    }

}