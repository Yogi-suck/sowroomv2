package com.sowroom.app.data.repository

import com.sowroom.app.data.model.ActionState
import com.sowroom.app.data.model.Book
import com.sowroom.app.data.remote.BookService
import com.sowroom.app.data.remote.RetrofitApi
import retrofit2.await
import java.lang.Exception

class BookRepository {
    private val bookService : BookService by lazy { RetrofitApi.bookService() }

    suspend fun listBook() : ActionState<List<Book>> {
        return try {
            val list = bookService.listBook().await()
            ActionState(list.data)
        } catch (e: Exception) {
            ActionState(message = e.message, isSuccess = false)
        }
    }

    suspend fun detailBook(url: String) : ActionState<Book> {
        return try {
            val list = bookService.detailBook(url).await()
            ActionState(list.data.first())
        } catch (e: Exception) {
            ActionState(message = e.message, isSuccess = false)
        }
    }

    suspend fun searchBook(query: String) : ActionState<List<Book>> {
        return try {
            val list = bookService.searchBook(query).await()
            ActionState(list.data)
        } catch (e: Exception) {
            ActionState(message = e.message, isSuccess = false)
        }
    }
}