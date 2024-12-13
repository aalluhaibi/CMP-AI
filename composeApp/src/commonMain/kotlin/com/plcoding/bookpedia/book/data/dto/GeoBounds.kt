package com.plcoding.bookpedia.book.data.dto

import kotlinx.serialization.Serializable

@Serializable
data class GeoBounds(
    val circle: Circle? = null
)