package com.example.fooddelivery.ui.screens.catalog.view_models

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.entities.Category
import com.example.domain.network.categories.use_case.GetAllCategoriesUseCase
import com.example.domain.utils.LoadingStatus
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class CatalogCategoryViewModel @Inject constructor(
    private val getAllCategoriesUseCase: GetAllCategoriesUseCase
) : ViewModel() {

    var categoryList: MutableLiveData<List<Category>> = MutableLiveData()
    var selectedCategoryButton: MutableState<Int> = mutableStateOf(0)

    fun getAllCategories() {
        getAllCategoriesUseCase.invoke().flowOn(Dispatchers.IO).onEach {
            if (it is LoadingStatus.Success) {
                selectedCategoryButton.value = it.result.first().id
                categoryList.postValue(it.result)
            }
        }.launchIn(viewModelScope)
    }
}