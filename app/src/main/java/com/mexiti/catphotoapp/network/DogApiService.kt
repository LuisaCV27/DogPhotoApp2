package com.mexiti.catphotoapp.network

import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import com.mexiti.catphotoapp.model.DogPhoto
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Retrofit
import retrofit2.http.GET

private const val BASE_URL = "https://api.thedogapi.com/"

private val retrofit = Retrofit.Builder()
    .addConverterFactory(Json.asConverterFactory("application/json".toMediaType()))
    .baseUrl(BASE_URL)
    .build()

interface DogApiService{
    @GET("v1/images/search?limit=10")
    suspend fun getPhotos():List<DogPhoto>
}

object DogApi {
    val retrofitService: DogApiService by lazy{
        retrofit.create(DogApiService::class.java)
    }
}