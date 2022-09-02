package com.dw.mvvm_kotlin_retrofit.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.dw.mvvm_kotlin_retrofit.MainViewHolder
import com.dw.mvvm_kotlin_retrofit.R
import com.dw.mvvm_kotlin_retrofit.model.Films
import com.dw.mvvm_kotlin_retrofit.model.Movie

class FilmAdapter : RecyclerView.Adapter<MyViewHolder>() {

    var films = mutableListOf<Films>()

    fun setfilmslist(movies: List<Films>) {
        this.films = movies.toMutableList()
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.filmsdesign, parent, false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val film = films[position]
        holder.text.setText(film.name)
        holder.text1.setText(film.desc)


    }

    override fun getItemCount(): Int {
        return films.size
    }
}
    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        var text=itemView.findViewById<TextView>(R.id.text)
        var text1=itemView.findViewById<TextView>(R.id.text1)
}
