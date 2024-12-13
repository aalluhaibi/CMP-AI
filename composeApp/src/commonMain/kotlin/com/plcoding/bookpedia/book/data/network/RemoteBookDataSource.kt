package com.plcoding.bookpedia.book.data.network

import com.plcoding.bookpedia.book.data.dto.PlacesDto
import com.plcoding.bookpedia.core.domain.DataError
import com.plcoding.bookpedia.core.domain.Result

interface RemotePlaceDataSource {
    suspend fun getPlaces(): Result<PlacesDto, DataError.Remote>
    suspend fun getPlaceDetails(placeWorkId: String): Result<PlacesDto, DataError.Remote>
}