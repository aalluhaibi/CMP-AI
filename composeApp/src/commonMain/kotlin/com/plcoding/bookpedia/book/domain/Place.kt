package com.plcoding.bookpedia.book.domain

data class Place(
    val id: String?= null,
    val name: String?= null,
    val iconUrl: String?= null,
    val categories: List<String?> = emptyList(),
    val location: String?= null
)
