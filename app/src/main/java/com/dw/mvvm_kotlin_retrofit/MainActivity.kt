package com.dw.mvvm_kotlin_retrofit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.dw.mvvm_kotlin_retrofit.api.RetrofitService
import com.dw.mvvm_kotlin_retrofit.databinding.ActivityMainBinding
import com.dw.mvvm_kotlin_retrofit.repository.MainRepository
import com.dw.mvvm_kotlin_retrofit.viewmodel.MainViewModel
import com.dw.mvvm_kotlin_retrofit.viewmodel.MyViewModelFactory

class MainActivity : AppCompatActivity() {

    private val TAG = "MainActivity"
    private lateinit var binding: ActivityMainBinding

    lateinit var viewModel: MainViewModel

    private val retrofitService = RetrofitService.getInstance()
    val adapter = MainAdapter()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        viewModel =
            ViewModelProvider(this, MyViewModelFactory(MainRepository(retrofitService))).get(
                MainViewModel::class.java
            )


        val llm = LinearLayoutManager(this)
        llm.orientation = LinearLayoutManager.VERTICAL
        binding. recyclerview.setLayoutManager(llm)
        binding. recyclerview.setAdapter(adapter)

        viewModel.movieList.observe(this, Observer {

            Log.d(TAG, "movieList: $it")
            adapter.setMovieList(it)
        })

        viewModel.errorMessage.observe(this, Observer {
            Log.d(TAG, "errorMessage: $it")
        })

        viewModel.getAllMovies()
    }

    }

