package com.plcoding.bookpedia.book.data.dto

import kotlinx.serialization.Serializable

@Serializable
data class RelatedPlaces(
    val children: List<Children>? = emptyList()
)
