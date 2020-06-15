package com.example.mycabaca.api

import com.example.mycabaca.data.source.remote.response.book.BookResponse
import com.example.mycabaca.data.source.remote.response.book.ResultItem
import com.example.mycabaca.data.source.remote.response.genre.GenreResponse
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Path

interface ApiService {
    @Headers("x-dreamfactory-api-key: 25e0bf00ab2fa7f03a9fa57035139e47ccb28c20658f6de907b8011347e369fb")
    @GET("cabaca/_table/genre")
    fun getGenre(): Call<GenreResponse>

    @Headers("x-dreamfactory-api-key: 25e0bf00ab2fa7f03a9fa57035139e47ccb28c20658f6de907b8011347e369fb")
    @GET("book/uptodate?limit=7")
    fun getNewUpdateBook(): Call<BookResponse>

    @Headers("x-dreamfactory-api-key: 25e0bf00ab2fa7f03a9fa57035139e47ccb28c20658f6de907b8011347e369fb")
    @GET("book/category?id={genre_id}")
    fun getDetailGenre(@Path("genre_id") genreId: String): Call<ResultItem>

}