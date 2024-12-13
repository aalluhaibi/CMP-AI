package com.plcoding.bookpedia.book.data.dto

import kotlinx.serialization.Serializable

@Serializable
data class Result(
    val categories: List<Category>? = listOf(),
    val chains: List<Chain?> = listOf(),
    val closed_bucket: String,
    val distance: Int,
    val fsq_id: String,
    val geocodes: Geocodes?= null,
    val link: String,
    val location: Location?= null,
    val name: String,
    val related_places: RelatedPlaces?= null,
    val timezone: String
)

@Serializable
data class Chain(
    val id: String?= null,
    val name: String?= null
)