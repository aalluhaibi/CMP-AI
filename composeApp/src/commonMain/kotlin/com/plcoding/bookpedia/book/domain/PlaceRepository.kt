package com.plcoding.bookpedia.book.domain

import com.plcoding.bookpedia.core.domain.DataError
import com.plcoding.bookpedia.core.domain.Result


interface PlaceRepository {
    suspend fun searchPlaces(): Result<List<Place>, DataError.Remote>
}