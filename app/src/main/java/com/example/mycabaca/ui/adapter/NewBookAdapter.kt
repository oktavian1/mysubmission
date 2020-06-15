package com.example.mycabaca.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.mycabaca.R
import com.example.mycabaca.data.source.remote.response.book.ResultItem
import com.example.mycabaca.data.source.remote.response.genre.Genre
import kotlinx.android.synthetic.main.genre_item.view.*
import kotlinx.android.synthetic.main.new_book.view.*

class NewBookAdapter(private val book : MutableList<ResultItem>): RecyclerView.Adapter<NewBookAdapter.ViewHolder>() {

    fun add(book: List<ResultItem>){
        this.book.clear()
        this.book.addAll(book)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.new_book, parent, false))
    }

    override fun getItemCount(): Int = book.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(book[position])
    }

    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {

        private val url = "https://cabaca.id:8443/api/v2/files/"
        private val api = "api_key=32ded42cfffb77dee86a29f43d36a3641849d4b5904aade9a79e9aa6cd5b5948"
        private lateinit var book : ResultItem

        fun bind(book: ResultItem){
            this.book= book

            Glide.with(itemView.context)
                .load(url + book.coverUrl+"&"+ api)
                .into(itemView.imageView)
        }

    }
}