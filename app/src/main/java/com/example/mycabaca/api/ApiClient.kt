package com.example.mycabaca.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiClient {

    private val API_URL = "https://cabaca.id:8443/api/v2/"

    fun create(): ApiService{
        val retrofit = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(API_URL)
            .build()
        return retrofit.create(ApiService::class.java)
    }

}