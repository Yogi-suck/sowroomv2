package com.sowroom.app.data.model

data class BookList(
        val data: List<Book> = arrayListOf(),
        val length: Int = 0,
        val status: Int = 0
)
