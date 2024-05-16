package com.example.data.entities

import com.google.gson.annotations.SerializedName

data class TagApiResponse(
    @SerializedName("id")
    val id : Int,
    @SerializedName("name")
    val name : String
)