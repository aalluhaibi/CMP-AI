package com.plcoding.bookpedia.book.data.dto

import kotlinx.serialization.Serializable

@Serializable
data class Circle(
    @Serializable
    val center: Center? = null,
    val radius: Int? = 0
)