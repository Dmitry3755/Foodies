package com.example.data.api

import com.example.data.entities.CategoryApiResponse
import retrofit2.Response
import retrofit2.http.GET

interface CategoriesApi {
    @GET("Categories.json")
    suspend fun getAllCategories(): Response<List<CategoryApiResponse>>
}