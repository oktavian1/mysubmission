package com.example.mycabaca.data.source

import androidx.lifecycle.LiveData
import com.example.mycabaca.data.source.remote.response.book.Result
import com.example.mycabaca.data.source.remote.response.book.ResultItem
import com.example.mycabaca.data.source.remote.response.genre.Genre
import com.example.mycabaca.data.source.remote.response.writer.ResultWriter
import com.example.mycabaca.di.Either

interface DataSource {

    fun getGenre(): LiveData<Either<List<Genre>>>
    fun getBook(): LiveData<Either<List<ResultItem>>>
    fun getDetailGenre(id: String): LiveData<Either<List<ResultItem>>>
    fun getDetail(id: String): LiveData<Either<Result>>
    fun getWriter(id: String):LiveData<Either<ResultWriter>>

}