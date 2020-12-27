package com.sowroom.app.ui.book

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.sowroom.app.R

class BookActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_book)
    }
    companion object {
        const val OPEN_BOOK = "open_book"
    }
}