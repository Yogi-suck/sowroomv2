package com.sowroom.app.data.remote

import com.sowroom.app.data.model.BookList
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface BookService {
    @GET("/")
    fun listBook() : Call<BookList>

    @GET ("detail/")
    fun detailBook(@Query("url") url : String) : Call<BookList>

    @GET ("search/")
    fun searchBook(@Query("q") query : String) : Call<BookList>
}