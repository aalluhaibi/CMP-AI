package com.plcoding.bookpedia.book.data.mappers

import com.plcoding.bookpedia.book.data.dto.PlacesDto
import com.plcoding.bookpedia.book.domain.Place

fun PlacesDto.toPlaceModel(): List<Place> {
    return results.map { result ->
        val iconUrl = result.categories?.firstOrNull()?.let { category ->
            "${category.icon?.prefix}bg_64${category.icon?.suffix}"
        } ?: ""
        val categoryNames = result.categories?.map { it.name }
        val location = result.location?.formatted_address
        Place(
            id = result.fsq_id,
            name = result.name,
            iconUrl = iconUrl,
            categories = categoryNames ?: listOf(),
            location = location
        )
    }
}

