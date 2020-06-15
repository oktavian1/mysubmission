package com.example.mycabaca.ui.adapter

import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.mycabaca.R
import com.example.mycabaca.data.source.remote.response.book.ResultItem
import com.example.mycabaca.ui.dashboard.DetailActivity
import kotlinx.android.synthetic.main.genre_all_item.*
import kotlinx.android.synthetic.main.genre_all_item.view.*

class GenreAllAdapter(private val list: MutableList<ResultItem>): RecyclerView.Adapter<GenreAllAdapter.ViewHolder>() {

    fun set(allGenre: List<ResultItem>){
            this.list.clear()
            this.list.addAll(allGenre)
            notifyDataSetChanged()

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.genre_all_item, parent, false))
    }

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(list[position])
    }

    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {

        private val url = "https://cabaca.id:8443/api/v2/files/"
        private val api = "api_key=32ded42cfffb77dee86a29f43d36a3641849d4b5904aade9a79e9aa6cd5b5948"
        private lateinit var book : ResultItem

        fun bind(book: ResultItem){
            this.book= book

            Glide.with(itemView.context)
                .load(url + book.coverUrl+"&"+ api)
                .into(itemView.imageAll)

            Log.d("ass", book.writerByWriterId?.id.toString())

            itemView.cvALlGenre.setOnClickListener {
                val i = Intent(itemView.context, DetailActivity::class.java).apply{
                    putExtra(DetailActivity.EXTRA_ID, book.id.toString())
                }
                itemView.context.startActivity(i)
            }

        }


    }
}