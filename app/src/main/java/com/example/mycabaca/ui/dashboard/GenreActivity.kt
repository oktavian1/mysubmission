package com.example.mycabaca.ui.dashboard

import android.app.Application
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.mycabaca.R
import com.example.mycabaca.ui.adapter.GenreAdapter
import com.example.mycabaca.ui.adapter.GenreAllAdapter
import com.example.mycabaca.ui.adapter.NewBookAdapter
import com.example.mycabaca.viewmodel.GenreViewModel

class GenreActivity : AppCompatActivity() {

    companion object{
        const val EXTRA_GENRE = "genre"
    }

//    private lateinit var genreViewModel : GenreViewModel
//    private val adapter = GenreAllAdapter(mutableListOf())

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_genre)

//
//        genreViewModel = ViewModelProvider.AndroidViewModelFactory.getInstance(application).create(GenreViewModel::class.java)
//
//        val ex = intent.extras
//
//        if (ex != null){
//            val id = ex.getString(EXTRA_GENRE)
//            if (id != null){
//                genreViewModel.selectedGenre(id)
//                genreViewModel.getGenreAll().observe(this, Observer {
////                    adapter.set(it.data)
//                })
//
//            }
//        }


    }
}
