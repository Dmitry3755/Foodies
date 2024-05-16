package com.example.data.mappers

import com.example.data.entities.CategoryApiResponse
import com.example.domain.entities.Category

fun CategoryApiResponse.toCategory(): Category {
    return Category(
        id = this.id,
        name = this.name
    )
}