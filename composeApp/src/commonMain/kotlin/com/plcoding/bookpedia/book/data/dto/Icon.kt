package com.plcoding.bookpedia.book.data.dto

import kotlinx.serialization.Serializable

@Serializable
data class Icon(
    val prefix: String ?= null,
    val suffix: String ?= null
)