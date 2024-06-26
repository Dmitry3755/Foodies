package com.example.data.entities

import com.google.gson.annotations.SerializedName

data class CategoryApiResponse(
    @SerializedName("id")
    val id : Int,
    @SerializedName("name")
    val name : String
)