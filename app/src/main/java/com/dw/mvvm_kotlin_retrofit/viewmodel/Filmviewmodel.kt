package com.dw.mvvm_kotlin_retrofit.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.dw.mvvm_kotlin_retrofit.model.Films
import com.dw.mvvm_kotlin_retrofit.repository.FilmRepository
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class Filmviewmodel constructor(private val repository: FilmRepository)  : ViewModel()  {

    val filmlist = MutableLiveData<List<Films>>()
    val errorMessage = MutableLiveData<String>()

    fun fetallfilms(){

        val response = repository.getAllfilms()
        response.enqueue(object : Callback<List<Films>> {
            override fun onResponse(call: Call<List<Films>>, response: Response<List<Films>>) {
                filmlist.postValue(response.body())
            }
            override fun onFailure(call: Call<List<Films>>, t: Throwable) {
                errorMessage.postValue(t.message)
            }
        })
    }
}