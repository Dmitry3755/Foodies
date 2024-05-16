package com.example.data.repositories_impl.network_impl.products

import com.example.data.api.ProductsApi
import com.example.data.entities.ProductApiResponse
import com.example.data.mappers.toProduct
import com.example.domain.network.products.repositories.ProductNetRepository
import com.example.domain.utils.LoadingStatus
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class ProductNetRepositoriesImpl @Inject constructor(private val productsApi: ProductsApi) :
    ProductNetRepository {

    override fun getAllProducts() = flow {
        emit(LoadingStatus.Loading())
        try {
            val response = productsApi.getAllProducts()
            if (response.isSuccessful) {
                emit(LoadingStatus.Success(response.body()!!.map { it.toProduct() }))
            } else {
                emit(LoadingStatus.Failed(response.errorBody().toString()))
            }
        } catch (e: Exception) {
            emit(LoadingStatus.Failed(e.message.toString()))
        }
    }

}