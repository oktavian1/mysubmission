package com.example.mycabaca.di

import com.example.mycabaca.api.ApiClient
import com.example.mycabaca.api.ApiService
import com.example.mycabaca.data.source.DataSource
import com.example.mycabaca.data.source.local.LocalRepository
import com.example.mycabaca.data.source.remote.RemoteRepository
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object Injection {

//    fun cabacaRepository(): DataRepository?{
//        val localRepository = LocalRepository()
//        val remoteRepository = RemoteRepository.getInstance(ApiClient)
//        return DataRepository.getInstance(localRepository, remoteRepository)
//    }


    fun provideRepository(): DataSource = RemoteRepository

    private fun provideRetrofit(): Retrofit{
        return Retrofit.Builder()
            .baseUrl("https://cabaca.id:8443/api/v2/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    fun provideApi(): ApiService{
        return provideRetrofit().create(ApiService::class.java)
    }


}