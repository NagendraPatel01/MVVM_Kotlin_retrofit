package com.dw.mvvm_kotlin_retrofit.model


import android.graphics.Movie
import com.google.gson.annotations.SerializedName

data class MovieList(@SerializedName("Search") val mList : List<com.dw.mvvm_kotlin_retrofit.model.Movie>)
