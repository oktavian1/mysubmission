package com.example.mycabaca.data.source.remote

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.mycabaca.api.ApiClient
import com.example.mycabaca.data.source.DataSource
import com.example.mycabaca.data.source.remote.response.book.BookResponse
import com.example.mycabaca.data.source.remote.response.book.ResultItem
import com.example.mycabaca.data.source.remote.response.genre.Genre
import com.example.mycabaca.data.source.remote.response.genre.GenreResponse
import com.example.mycabaca.di.ApiError
import com.example.mycabaca.di.Either
import com.example.mycabaca.di.Injection
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

object RemoteRepository: DataSource {

    private val api = Injection.provideApi()

    override fun getGenre(): LiveData<Either<List<Genre>>> {
        val liveData = MutableLiveData<Either<List<Genre>>>()

        api.getGenre().enqueue(object: Callback<GenreResponse>{
            override fun onResponse(call: Call<GenreResponse>, response: Response<GenreResponse>) {
                if(response != null && response.isSuccessful){
                    liveData.value = Either.success(response.body()?.resource)
                }else{
                    liveData.value = Either.error(ApiError.GENRE, null)
                }
            }

            override fun onFailure(call: Call<GenreResponse>, t: Throwable) {
                liveData.value = Either.error(ApiError.GENRE, null)
            }
        })

        return liveData
    }

    override fun getBook(): LiveData<Either<List<ResultItem>>> {
        val liveData = MutableLiveData<Either<List<ResultItem>>>()

        api.getNewUpdateBook().enqueue(object: Callback<BookResponse>{
            override fun onResponse(call: Call<BookResponse>, response: Response<BookResponse>) {
                if (response!=null && response.isSuccessful){
                    liveData.value = Either.success(response.body()?.result)
                }else{
                    liveData.value = Either.error(ApiError.NEMBOOK, null)
                }
            }

            override fun onFailure(call: Call<BookResponse>, t: Throwable) {
                liveData.value = Either.error(ApiError.NEMBOOK, null)
            }
        })
        return liveData
    }

    override fun getDetailGenre(id: String): LiveData<Either<ResultItem>> {
        val liveData = MutableLiveData<Either<ResultItem>>()

        api.getDetailGenre(id).enqueue(object : Callback<ResultItem>{
            override fun onResponse(call: Call<ResultItem>, response: Response<ResultItem>) {
                if (response!=null && response.isSuccessful){
                    liveData.value = Either.success(response.body())
                }else{
                    liveData.value = Either.error(ApiError.DETAILGENRE, null)
                }
            }

            override fun onFailure(call: Call<ResultItem>, t: Throwable) {
                liveData.value = Either.error(ApiError.DETAILGENRE, null)
            }
        })
        return liveData
    }
}