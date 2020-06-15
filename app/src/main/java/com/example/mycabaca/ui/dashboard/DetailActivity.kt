package com.example.mycabaca.ui.dashboard

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.example.mycabaca.R
import com.example.mycabaca.di.ApiError
import com.example.mycabaca.di.Status
import com.example.mycabaca.viewmodel.DetailViewModel
import kotlinx.android.synthetic.main.activity_detail.*
import kotlinx.android.synthetic.main.activity_genre.*

class DetailActivity : AppCompatActivity() {

    companion object{
        const val EXTRA_ID = "id"
    }

    private lateinit var detailViewModel : DetailViewModel
    private val url = "https://cabaca.id:8443/api/v2/files/"
    private val api = "api_key=32ded42cfffb77dee86a29f43d36a3641849d4b5904aade9a79e9aa6cd5b5948"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        detailViewModel = ViewModelProvider.AndroidViewModelFactory.getInstance(application).create(DetailViewModel::class.java)

        val i = intent.extras

        if (i != null){
            val id = i?.getString(EXTRA_ID)
            Log.d("casa", i.toString())
            if (id != null){
                detailViewModel.selectedBook(id)
                detailViewModel.getDetailBook(id.toString()).observe(this, Observer {
                    if (it?.status == Status.SUCCESS && it.data != null) {
                        Glide.with(this)
                            .load(url + it.data.writerByWriterId?.userByUserId?.photoUrl+"&"+ api)
                            .into(img)

                        titleBook.text = it.data.title
                        txtSinopsis.text = it.data.desc
//                        Log.d("image", it.data.writerByWriterId?.userByUserId?.photoUrl.toString())
//                        Log.d("image", it.data.toString()) nulllllllllll

                        Glide.with(this)
                            .load(url + it.data.writerByWriterId?.userByUserId?.photoUrl +"&"+ api)
                            .into(imageView3)

                        writedBy.text = it.data.writerByWriterId?.userByUserId?.name

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
