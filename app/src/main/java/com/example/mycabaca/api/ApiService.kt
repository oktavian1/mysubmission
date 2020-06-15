package com.example.mycabaca.api

import com.example.mycabaca.data.source.remote.response.book.BookResponse
import com.example.mycabaca.data.source.remote.response.book.DetailResponse
import com.example.mycabaca.data.source.remote.response.book.ResultItem
import com.example.mycabaca.data.source.remote.response.genre.GenreResponse
import com.example.mycabaca.data.source.remote.response.writer.WriterResponse
import retrofit2.Call
import retrofit2.http.*

interface ApiService {
    @Headers("x-dreamfactory-api-key: 25e0bf00ab2fa7f03a9fa57035139e47ccb28c20658f6de907b8011347e369fb")
    @GET("cabaca/_table/genre")
    fun getGenre(): Call<GenreResponse>

    @Headers("x-dreamfactory-api-key: 25e0bf00ab2fa7f03a9fa57035139e47ccb28c20658f6de907b8011347e369fb")
    @GET("book/uptodate?limit=7")
    fun getNewUpdateBook(): Call<BookResponse>

    @Headers("x-dreamfactory-api-key: 25e0bf00ab2fa7f03a9fa57035139e47ccb28c20658f6de907b8011347e369fb")
    @GET("book/category")
    fun getDetailGenre(@Query("id") genreId: String): Call<BookResponse>

    @Headers("x-dreamfactory-api-key: 25e0bf00ab2fa7f03a9fa57035139e47ccb28c20658f6de907b8011347e369fb")
    @GET("book/detail/{book_id}")
    fun getDetailBook(@Path("book_id") id: String): Call<DetailResponse>

    @Headers("x-dreamfactory-api-key: 25e0bf00ab2fa7f03a9fa57035139e47ccb28c20658f6de907b8011347e369fb")
    @GET("book/writer/detail/{user_id}")
    fun getReviewer(@Path("user_id") id: String): Call<WriterResponse>

}