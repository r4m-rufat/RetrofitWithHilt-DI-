package com.codingwithrufat.filmswithhilt.repository

import android.util.Log
import com.codingwithrufat.filmswithhilt.models.ResponseItem
import com.codingwithrufat.filmswithhilt.network.ApiService
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

class FilmRepository
@Inject
constructor(val apiService: ApiService){
    private val TAG = "FilmRepository"

    fun getFilms(): List<ResponseItem?>? {
        var data:  List<ResponseItem?>? = null
        CoroutineScope(IO).launch {
            apiService.getPhotos().enqueue(object : Callback<List<ResponseItem>>{
                override fun onResponse(
                    call: Call<List<ResponseItem>>,
                    response: Response<List<ResponseItem>>
                ) {
                    Log.d(TAG, "onResponse: ${response.body()?.size}")
                }

                override fun onFailure(
                    call: Call<List<ResponseItem>>,
                    t: Throwable
                ) {
                    Log.d(TAG, "onFailure: ${t.message}")
                }

            })

        }
        return data
    }

}