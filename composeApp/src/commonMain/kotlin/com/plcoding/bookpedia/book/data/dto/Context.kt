package com.plcoding.bookpedia.book.data.dto

import kotlinx.serialization.Serializable

@Serializable
data class Context(
    val geo_bounds: GeoBounds? = null
)