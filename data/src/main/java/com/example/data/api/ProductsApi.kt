package com.example.data.api

import com.example.data.entities.ProductApiResponse
import retrofit2.Response
import retrofit2.http.GET

interface ProductsApi {

    @GET("Products.json")
    suspend fun getAllProducts(): Response<List<ProductApiResponse>>

}