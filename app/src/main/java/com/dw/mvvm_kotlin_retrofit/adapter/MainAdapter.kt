package com.dw.mvvm_kotlin_retrofit

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.dw.mvvm_kotlin_retrofit.databinding.LayoutRvItemBinding
import com.dw.mvvm_kotlin_retrofit.model.Films
import com.dw.mvvm_kotlin_retrofit.model.Movie

class MainAdapter : RecyclerView.Adapter<MainViewHolder>() {

    var movies = mutableListOf<Movie>()

    fun setMovieList(movies: List<Movie>) {
        this.movies = movies.toMutableList()
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {

        val inflater = LayoutInflater.from(parent.context)
        val binding = LayoutRvItemBinding.inflate(inflater, parent, false)
        return MainViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        val movie = movies[position]
        holder.binding.movieTitle.text = movie.title
        Glide.with(holder.itemView.context).load(movie.poster).placeholder(R.drawable.img)
            .into(holder.binding.moviePoster)

    }

    override fun getItemCount(): Int {
        return movies.size
    }
}

class MainViewHolder(val binding: LayoutRvItemBinding) : RecyclerView.ViewHolder(binding.root) {

}