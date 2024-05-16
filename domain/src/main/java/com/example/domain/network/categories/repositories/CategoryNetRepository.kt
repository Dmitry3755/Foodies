package com.example.domain.network.categories.repositories

import com.example.domain.entities.Category
import com.example.domain.utils.LoadingStatus
import kotlinx.coroutines.flow.Flow

interface CategoryNetRepository {

    fun getAllCategories(): Flow<LoadingStatus<List<Category>>>

}