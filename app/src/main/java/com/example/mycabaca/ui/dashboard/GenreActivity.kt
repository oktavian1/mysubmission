package com.example.mycabaca.ui.dashboard

import android.app.Application
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.LinearLayout
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mycabaca.R
import com.example.mycabaca.di.ApiError
import com.example.mycabaca.di.Status
import com.example.mycabaca.ui.adapter.GenreAdapter
import com.example.mycabaca.ui.adapter.GenreAllAdapter
import com.example.mycabaca.ui.adapter.NewBookAdapter
import com.example.mycabaca.viewmodel.DetailViewModel
import com.example.mycabaca.viewmodel.GenreViewModel
import kotlinx.android.synthetic.main.activity_genre.*

class GenreActivity : AppCompatActivity() {

    companion object{
        const val EXTRA_GENRE = "genre"
    }


    private lateinit var detailViewModel : DetailViewModel
    private val adapter = GenreAllAdapter(mutableListOf())

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_genre)


        detailViewModel = ViewModelProvider.AndroidViewModelFactory.getInstance(application).create(DetailViewModel::class.java)

        val ex = intent.extras


        Log.d("genre", ex.toString())

        if (ex != null){
            val id = ex?.getString(EXTRA_GENRE)
            Log.d("tester", id.toString())
            if (id != null){
                detailViewModel.selectedGenre(id.toString() )
                detailViewModel.getGenreAll(id.toString()).observe(this, Observer {
                    if (it?.status == Status.SUCCESS && it.data != null) {

                        genreAll.layoutManager = LinearLayoutManager(this)
                        genreAll.adapter = adapter

                        Log.d("cekcek", it.data.toString())
                        adapter.set(it.data)
                        adapter.notifyDataSetChanged()
                    } else {
                        if (it?.error == ApiError.GENRE) {
                            Toast.makeText(this, "error", Toast.LENGTH_SHORT).show()
                        }
                    }
                })


            }
        }



    }
}
