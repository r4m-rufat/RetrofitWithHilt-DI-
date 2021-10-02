package com.codingwithrufat.filmswithhilt.network

import com.codingwithrufat.filmswithhilt.models.ResponseItem
import com.codingwithrufat.filmswithhilt.utils.ACCESS_KEY
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {

    @GET(ACCESS_KEY)
    fun getPhotos(): Call<List<ResponseItem>>

}