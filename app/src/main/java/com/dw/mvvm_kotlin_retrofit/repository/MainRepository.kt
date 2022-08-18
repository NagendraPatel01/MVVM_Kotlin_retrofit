package com.dw.mvvm_kotlin_retrofit.repository

import com.dw.mvvm_kotlin_retrofit.api.RetrofitService

class MainRepository constructor(private val retrofitService: RetrofitService) {

    fun getAllMovies() = retrofitService.getAllMovies()
}