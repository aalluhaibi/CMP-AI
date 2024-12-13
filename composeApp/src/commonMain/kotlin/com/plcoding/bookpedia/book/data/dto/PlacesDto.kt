package com.plcoding.bookpedia.book.data.dto

import kotlinx.serialization.Serializable

@Serializable
data class PlacesDto(
    val context: Context? = null,
    val results: List<Result> = listOf()
)