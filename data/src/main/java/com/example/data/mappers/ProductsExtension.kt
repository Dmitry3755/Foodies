package com.example.data.mappers

import com.example.data.entities.CategoryApiResponse
import com.example.data.entities.ProductApiResponse
import com.example.domain.entities.Category
import com.example.domain.entities.Product
import com.example.domain.entities.Tag

fun ProductApiResponse.toProduct(): Product {
    return Product(
        id = this.id,
        categoryId = this.categoryId,
        name = this.name,
        description = this.description,
        image = this.image,
        priceCurrent = this.priceCurrent,
        priceOld = this.priceOld,
        measure = this.measure,
        measureUnit = this.measureUnit,
        energyPerHundredGrams = this.energyPerHundredGrams,
        proteinsPerHundredGrams = this.proteinsPerHundredGrams,
        fatsPerHundredGrams = this.fatsPerHundredGrams,
        carbohydratesPerHundredGrams = this.carbohydratesPerHundredGrams,
        tags = if (this.tags.isNullOrEmpty()) {
            listOf()
        } else {
            this.tags
        }
    )
}