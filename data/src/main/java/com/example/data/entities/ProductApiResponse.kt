package com.example.data.entities

import com.google.gson.annotations.SerializedName

data class ProductApiResponse(
    @SerializedName("id")
    val id: Int,
    @SerializedName("category_id")
    val categoryId: Int,
    @SerializedName("name")
    val name: String,
    @SerializedName("description")
    val description: String,
    @SerializedName("image")
    val image: String,
    @SerializedName("price_current")
    val priceCurrent: Double,
    @SerializedName("price_old")
    val priceOld: Double?,
    @SerializedName("measure")
    val measure: Int,
    @SerializedName("measure_unit")
    val measureUnit: String,
    @SerializedName("energy_per_100_grams")
    val energyPerHundredGrams: Double,
    @SerializedName("proteins_per_100_grams")
    val proteinsPerHundredGrams: Double,
    @SerializedName("fats_per_100_grams")
    val fatsPerHundredGrams: Double,
    @SerializedName("carbohydrates_per_100_grams")
    val carbohydratesPerHundredGrams: Double,
    @SerializedName("tag_ids")
    val tags: List<Int>?
)