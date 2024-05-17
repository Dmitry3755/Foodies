package com.example.fooddelivery.ui.screens.catalog.view_models

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.entities.BasketItem
import com.example.domain.entities.Product
import com.example.domain.network.products.use_case.GetAllProductsUseCase
import com.example.domain.utils.LoadingStatus
import com.example.fooddelivery.ui.model.AppData
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

    var internalProductList: MutableLiveData<List<Product>> = MutableLiveData()
    var productList: LiveData<List<Product>> = internalProductList

    fun getAllProducts() {
        getAllProductsUseCase.invoke().flowOn(Dispatchers.IO).onEach {
            if (it is LoadingStatus.Success) {
                internalProductList.postValue(it.result)
            }
        }.launchIn(viewModelScope)
    }

    fun getProductsFilterList(): MutableList<Product> {
        return AppData.productsFilterList
    }

    fun getBasketList(): MutableList<BasketItem> {
        return AppData.basketList
    }

    fun filterList(selectedCategoryId: Int) {
        AppData.productsFilterList =
            internalProductList.value!!.filter { it.categoryId == selectedCategoryId }
                .toMutableList()
    }

    fun addProductOnBasket(product: Product, addNew: Boolean) {
        if (addNew) {
            AppData.basketList.add(BasketItem(1, product))
        } else {
            for (basketProduct in AppData.basketList) {
                if (basketProduct.product == product) {
                    basketProduct.count += 1
                }
            }
        }
    }

    fun reduceProductOnBasket(product: Product) {
        var reduce = 0
        for (basketProduct in AppData.basketList) {
            if (basketProduct.product == product && basketProduct.count >= 1) {
                basketProduct.count -= 1
                reduce = 1
                break
            }
        }
        if (reduce == 0) {
            AppData.basketList.removeAt(AppData.basketList.indexOf(AppData.basketList.first { basketItem: BasketItem -> basketItem.product == product }))
        }
    }

}