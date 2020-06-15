package com.example.mycabaca.ui.dashboard

import android.app.Application
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.lifecycle.ViewModelProviders.of
import androidx.recyclerview.widget.LinearLayoutManager

import com.example.mycabaca.R
import com.example.mycabaca.data.source.remote.response.genre.Genre
import com.example.mycabaca.di.ApiError
import com.example.mycabaca.di.Status
import com.example.mycabaca.ui.adapter.GenreAdapter
import com.example.mycabaca.ui.adapter.NewBookAdapter
import com.example.mycabaca.viewmodel.GenreViewModel
import kotlinx.android.synthetic.main.fragment_dashboard.*

class DashboardFragment : Fragment() {

    private lateinit var genreViewModel : GenreViewModel
    private val adapter = GenreAdapter(mutableListOf())
    private val application = Application()

    private val adapter2 = NewBookAdapter(mutableListOf())

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
         val root = inflater.inflate(R.layout.fragment_dashboard, container, false)
        return root
    }


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        genreViewModel = ViewModelProvider.AndroidViewModelFactory.getInstance(application).create(GenreViewModel::class.java)


        initListGenreUi()
        initListNewBook()

    }

    private fun initListGenreUi() {
        genreList.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        genreList.adapter = adapter

        genreViewModel.getGenre().observe(viewLifecycleOwner, Observer {
            if (it?.status == Status.SUCCESS && it.data != null) {
                adapter.addList(it.data)
            } else {
                if (it?.error == ApiError.GENRE) {
                    Toast.makeText(context, "error", Toast.LENGTH_SHORT).show()
                }
            }
        })
    }

    private fun initListNewBook(){
        newBookRv.layoutManager = LinearLayoutManager(context)
        newBookRv.adapter = adapter2

        genreViewModel.getBook().observe(viewLifecycleOwner, Observer {
            if (it?.status == Status.SUCCESS && it.data != null) {
                adapter2.add(it.data)
            } else {
                if (it?.error == ApiError.GENRE) {
                    Toast.makeText(context, "error", Toast.LENGTH_SHORT).show()
                }
            }
        })
    }


}
