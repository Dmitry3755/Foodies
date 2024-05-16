package com.example.domain.network.products.use_case

import com.example.domain.network.products.repositories.ProductNetRepository
import javax.inject.Inject

class GetAllProductsUseCase @Inject constructor(private val productNetRepository: ProductNetRepository) {
    operator fun invoke() = productNetRepository.getAllProducts()
}