package com.plcoding.bookpedia.book.data.dto

import kotlinx.serialization.Serializable

@Serializable
data class Children(
    val categories: List<Category>,
    val fsq_id: String,
    val name: String
)