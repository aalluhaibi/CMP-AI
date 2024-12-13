package com.plcoding.bookpedia.book.data.network

import com.plcoding.bookpedia.book.data.dto.PlacesDto
import com.plcoding.bookpedia.core.data.safeCall
import com.plcoding.bookpedia.core.domain.DataError
import com.plcoding.bookpedia.core.domain.Result
import io.ktor.client.HttpClient
import io.ktor.client.request.get
import io.ktor.client.request.header
import io.ktor.client.request.url

private const val BASE_URL = "https://api.foursquare.com"

class KtorRemotePlaceDataSource(
    private val httpClient: HttpClient
): RemotePlaceDataSource {
    override suspend fun getPlaces(): Result<PlacesDto, DataError.Remote> {
        return safeCall<PlacesDto> {
            httpClient.get {
                url("$BASE_URL/v3/places/search")
                header("Authorization", "fsq3vKmG6XGahHkbwVRBu9C0SSM4d7M0gE2Y7U8XK1XHotU=")
                header("accept", "application/json")
            }
        }
    }

    override suspend fun getPlaceDetails(placeWorkId: String): Result<PlacesDto, DataError.Remote> {
        TODO("Not yet implemented")
    }

}