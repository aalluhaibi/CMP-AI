package com.plcoding.bookpedia.book.data.repository

import com.plcoding.bookpedia.book.data.mappers.toPlaceModel
import com.plcoding.bookpedia.book.data.network.RemotePlaceDataSource
import com.plcoding.bookpedia.book.domain.Place
import com.plcoding.bookpedia.book.domain.PlaceRepository
import com.plcoding.bookpedia.core.domain.DataError
import com.plcoding.bookpedia.core.domain.Result
import com.plcoding.bookpedia.core.domain.map


class PlaceRepositoryImpl(
    private val dataSource: RemotePlaceDataSource
) : PlaceRepository {
    override suspend fun searchPlaces(): Result<List<Place>, DataError.Remote> {
        return dataSource.getPlaces().map { dto ->
            dto.toPlaceModel()
        }
    }
}