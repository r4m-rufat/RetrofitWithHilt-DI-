package com.codingwithrufat.filmswithhilt

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.codingwithrufat.filmswithhilt.databinding.ActivityMainBinding
import com.codingwithrufat.filmswithhilt.utils.ApiState
import com.codingwithrufat.filmswithhilt.viewmodel.MainActivityViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var recyclerView: RecyclerView
    lateinit var mainViewModel: MainActivityViewModel
    private val TAG = "MainActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        mainViewModel = ViewModelProvider(this).get(MainActivityViewModel::class.java)

        mainViewModel?.list?.observe(this, Observer { state ->
            when(state){

                is ApiState.SUCCESS -> {
                    Log.d(TAG, "onCreate: Size is ${state.data?.size}")
                }

                is ApiState.FAILURE -> {
                    Log.d(TAG, "onCreate: ${state.message}")
                }

                is ApiState.EMPTY -> {

                }
            }
        })

    }
}