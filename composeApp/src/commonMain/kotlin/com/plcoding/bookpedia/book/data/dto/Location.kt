package com.plcoding.bookpedia.book.data.dto

import kotlinx.serialization.Serializable

@Serializable
data class Location(
    val address: String?= null,
    val country: String?= null,
    val cross_street: String?= null,
    val formatted_address: String?= null,
    val locality: String?= null,
    val postcode: String?= null,
    val region: String?= null
)