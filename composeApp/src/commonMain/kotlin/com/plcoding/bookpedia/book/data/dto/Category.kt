package com.plcoding.bookpedia.book.data.dto

import kotlinx.serialization.Serializable

@Serializable
data class Category(
    val icon: Icon? = null,
    val id: Int? = -1,
    val name: String?= null,
    val plural_name: String?= null,
    val short_name: String?= null
)