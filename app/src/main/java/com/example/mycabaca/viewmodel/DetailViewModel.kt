package com.example.mycabaca.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.example.mycabaca.di.Injection

class DetailViewModel(app: Application): AndroidViewModel(app) {

    private lateinit var idGenre: String
    private lateinit var idBook: String
    private lateinit var idWriter: String
    private val repo = Injection.provideRepository()

    fun selectedGenre(id: String){
        this.idGenre = id
    }
    fun getGenreAll(id: String) = repo.getDetailGenre(id)

    fun selectedBook(id: String){
        this.idBook = id
    }

    fun getDetailBook(id: String) = repo.getDetail(id)

    fun getWriter(id: String) = repo.getWriter(id)

}