package com.example.domain.entities

data class Product(
    val id: Int,
    val categoryId: Int,
    val name: String,
    val description: String,
    val image: String,
    val priceCurrent: Double,
    val priceOld: Double?,
    val measure: Int,
    val measureUnit: String,
    val energyPerHundredGrams: Double,
    val proteinsPerHundredGrams: Double,
    val fatsPerHundredGrams: Double,
    val carbohydratesPerHundredGrams: Double,
    val tags: List<Int>
)