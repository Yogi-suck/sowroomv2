package com.sowroom.app.data.remote

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object RetrofitApi {
    const val BOOK_URL = "https://al-quran-8d642.firebaseio.com/data.json?print=pretty"

    private val client = OkHttpClient.Builder()
            .addInterceptor(HttpLoggingInterceptor().apply {
                level = HttpLoggingInterceptor.Level.BODY
            })
            .readTimeout(10, TimeUnit.SECONDS)
            .connectTimeout(10,TimeUnit.SECONDS)
            .build()

    private fun create(url: String) : Retrofit {
        val retrofit= Retrofit.Builder()
                .baseUrl(url)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        return retrofit
    }

    fun bookService() : BookService{
        return create(BOOK_URL).create(BookService::class.java)
    }
}