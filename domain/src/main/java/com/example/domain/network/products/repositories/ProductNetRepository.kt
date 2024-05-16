package com.example.domain.network.products.repositories

import com.example.domain.entities.Product
import com.example.domain.utils.LoadingStatus
import kotlinx.coroutines.flow.Flow

interface ProductNetRepository {

    fun getAllProducts(): Flow<LoadingStatus<List<Product>>>

}