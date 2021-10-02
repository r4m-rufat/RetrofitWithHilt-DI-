package com.codingwithrufat.filmswithhilt.di

import com.codingwithrufat.filmswithhilt.network.ApiService
import com.codingwithrufat.filmswithhilt.utils.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    fun providesUrl() = BASE_URL

    @Provides
    @Singleton
    fun providesApiService(url: String): ApiService{

        return Retrofit.Builder()
            .baseUrl(url)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiService::class.java)

    }

}