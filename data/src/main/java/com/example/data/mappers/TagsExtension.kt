package com.example.data.mappers

import com.example.data.entities.CategoryApiResponse
import com.example.data.entities.ProductApiResponse
import com.example.data.entities.TagApiResponse
import com.example.domain.entities.Category
import com.example.domain.entities.Product
import com.example.domain.entities.Tag

fun TagApiResponse.toTag(): Tag {
    return Tag(
        id = this.id,
        name = this.name
    )
}