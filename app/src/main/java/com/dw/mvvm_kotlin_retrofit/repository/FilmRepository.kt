package com.dw.mvvm_kotlin_retrofit.repository

import com.dw.mvvm_kotlin_retrofit.api.RetrofitBuilder

class FilmRepository constructor(private  val retrofitBuilder: RetrofitBuilder){

    fun getAllfilms() = retrofitBuilder.getAllfilms()

}