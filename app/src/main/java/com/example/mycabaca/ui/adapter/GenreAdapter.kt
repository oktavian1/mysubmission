package com.example.mycabaca.ui.adapter

import android.content.Context
import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.mycabaca.R
import com.example.mycabaca.data.source.remote.response.genre.Genre
import com.example.mycabaca.ui.dashboard.GenreActivity
import kotlinx.android.synthetic.main.fragment_dashboard.view.*
import kotlinx.android.synthetic.main.genre_item.view.*

class GenreAdapter(private val genre : MutableList<Genre>): RecyclerView.Adapter<GenreAdapter.ViewHolder>() {

   fun addList(genre: List<Genre>){
       this.genre.clear()
       this.genre.addAll(genre)
       notifyDataSetChanged()
   }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.genre_item, parent, false))
    }

    override fun getItemCount(): Int = genre.size


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
//        holder.showData(listGenre[position])
        holder.bind(genre[position])
    }

    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
//        private val url = "https://cabaca.id:8443/api/v2/files/"
//        private val api = "api_key=32ded42cfffb77dee86a29f43d36a3641849d4b5904aade9a79e9aa6cd5b5948"
        private lateinit var genre : Genre

        fun bind(genre: Genre ){
            this.genre = genre
            itemView.name.text = genre.title
            itemView.cvGenre.setOnClickListener {
                val i = Intent(itemView.context, GenreActivity::class.java).apply{
                    putExtra(GenreActivity.EXTRA_GENRE, genre.id.toString())
                    Log.d("click", genre.id.toString())
                }
                itemView.context.startActivity(i)
            }



//            Glide.with(itemView.context)
//                .load(url +"covers/"+ genre.iconUrl+ api)
//                .into(itemView.item_img)
        }

        fun showData(genre : Genre)= with(itemView){



//            Glide.with(this)
//                .load(api + genre.iconUrl)
//                .into(movieImage)
        }
    }
}