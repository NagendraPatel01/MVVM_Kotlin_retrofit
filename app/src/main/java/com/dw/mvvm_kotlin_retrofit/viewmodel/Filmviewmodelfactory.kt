package com.dw.mvvm_kotlin_retrofit.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.dw.mvvm_kotlin_retrofit.repository.FilmRepository

class Filmviewmodelfactory constructor(private val repository: FilmRepository): ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return if (modelClass.isAssignableFrom(Filmviewmodel::class.java)) {
            Filmviewmodel(this.repository) as T
        } else {
            throw IllegalArgumentException("ViewModel Not Found")
        }
    }
}