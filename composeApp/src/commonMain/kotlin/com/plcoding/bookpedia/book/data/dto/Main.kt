package com.plcoding.bookpedia.book.data.dto

import kotlinx.serialization.Serializable

@Serializable
data class Main(
    val latitude: Double? = 0.0,
    val longitude: Double?= 0.0
)