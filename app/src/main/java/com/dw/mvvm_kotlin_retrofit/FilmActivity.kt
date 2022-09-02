package com.dw.mvvm_kotlin_retrofit

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.dw.mvvm_kotlin_retrofit.adapter.FilmAdapter
import com.dw.mvvm_kotlin_retrofit.api.RetrofitBuilder
import com.dw.mvvm_kotlin_retrofit.databinding.ActivityMainBinding
import com.dw.mvvm_kotlin_retrofit.repository.FilmRepository
import com.dw.mvvm_kotlin_retrofit.viewmodel.Filmviewmodel
import com.dw.mvvm_kotlin_retrofit.viewmodel.Filmviewmodelfactory

class FilmActivity : AppCompatActivity() {

    private val TAG = "MainActivity"
    private lateinit var binding:ActivityMainBinding
    lateinit var viewModel: Filmviewmodel
    private val retrofitBuilder = RetrofitBuilder.getInsta()
    val adapter = FilmAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btn.setOnClickListener {

            val intent = Intent(this@FilmActivity, MainActivity::class.java)
            startActivity(intent)
        }

        viewModel = ViewModelProvider(this, Filmviewmodelfactory(FilmRepository(retrofitBuilder)))
            .get( Filmviewmodel::class.java )

        val llm = LinearLayoutManager(this)
        llm.orientation = LinearLayoutManager.VERTICAL
        binding. recyclerview.setLayoutManager(llm)
        binding. recyclerview.setAdapter(adapter)

        viewModel.filmlist.observe(this, Observer {

            Log.d(TAG, "movieList: $it")
            adapter.setfilmslist(it)

        })

        viewModel.errorMessage.observe(this, Observer {
            Log.d(TAG, "errorMessage: $it")
        })

       viewModel.fetallfilms()
    }
}