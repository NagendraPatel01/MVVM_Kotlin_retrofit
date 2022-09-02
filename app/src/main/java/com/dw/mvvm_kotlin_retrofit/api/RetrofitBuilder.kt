package com.dw.mvvm_kotlin_retrofit.api

import com.dw.mvvm_kotlin_retrofit.model.Films
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface RetrofitBuilder {

    @GET("movielist.json")
    fun getAllfilms() : Call<List<Films>>

    companion object {
        var retrofitBuilder: RetrofitBuilder? = null

        fun getInsta() : RetrofitBuilder {
            if (retrofitBuilder == null) {
                val retrofit = Retrofit.Builder()
                    .baseUrl("https://howtodoandroid.com/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
                retrofitBuilder = retrofit.create(RetrofitBuilder::class.java)
            }
            return retrofitBuilder!!
        }
    }

}