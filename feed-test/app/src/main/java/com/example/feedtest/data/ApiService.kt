package com.example.feedtest.data

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("people/")
    suspend fun getPeople(@Query("page") page: Int = 1): SwapiResponse
}

object RetrofitClient {
    private const val BASE_URL = "https://swapi.dev/api/"

    val instance: ApiService by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiService::class.java)
    }
}
