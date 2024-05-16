package com.example.data.repositories_impl.network_impl.categories

import com.example.data.api.CategoriesApi
import com.example.data.api.ProductsApi
import com.example.data.entities.ProductApiResponse
import com.example.data.mappers.toCategory
import com.example.domain.entities.Category
import com.example.domain.network.categories.repositories.CategoryNetRepository
import com.example.domain.network.products.repositories.ProductNetRepository
import com.example.domain.utils.LoadingStatus
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class CategoryNetRepositoriesImpl @Inject constructor(private val categoriesApi: CategoriesApi) :
    CategoryNetRepository {

    override fun getAllCategories() = flow {
        emit(LoadingStatus.Loading())
        try {
            val response = categoriesApi.getAllCategories()
            if (response.isSuccessful) {
                emit(LoadingStatus.Success(response.body()!!.map { it.toCategory() }))
            } else {
                emit(LoadingStatus.Failed(response.errorBody().toString()))
            }
        } catch (e: Exception) {
            emit(LoadingStatus.Failed(e.message.toString()))
        }
    }
}