package com.example.mycabaca.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.mycabaca.data.source.remote.response.genre.Genre
import com.example.mycabaca.di.Injection

class GenreViewModel(app: Application):AndroidViewModel(app)  {

    private val repo = Injection.provideRepository()
    private val getGenre = repo.getGenre()

    private val getUpdateNewBook = repo.getBook()

    fun getGenre() = getGenre
    fun getBook() = getUpdateNewBook


}
