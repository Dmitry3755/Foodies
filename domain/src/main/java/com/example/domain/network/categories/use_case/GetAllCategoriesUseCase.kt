package com.example.domain.network.categories.use_case

import com.example.domain.network.categories.repositories.CategoryNetRepository
import javax.inject.Inject

class GetAllCategoriesUseCase @Inject constructor(private val categoryNetRepository: CategoryNetRepository) {
    operator fun invoke() = categoryNetRepository.getAllCategories()
}