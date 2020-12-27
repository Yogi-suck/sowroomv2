package com.sowroom.app.ui.book

import android.content.Context
import android.content.Intent
import androidx.databinding.ViewDataBinding
import com.bumptech.glide.Glide
import com.sowroom.app.R
import com.sowroom.app.data.model.Book
import com.sowroom.app.databinding.ItemBookBinding
import com.sowroom.app.ui.base.BaseAdapter

class BookAdapter(val context: Context) : BaseAdapter<Book>(R.layout.item_book) {
    override fun onBind(binding: ViewDataBinding?, data: Book) {
        val mBinding = binding as ItemBookBinding
        Glide.with(context).load(data.audio).into(mBinding.itemPoster)
    }

    override fun onClick(binding: ViewDataBinding?, data: Book) {
        val intent = Intent(context, BookActivity::class.java)
        intent.putExtra(BookActivity.OPEN_BOOK, data)
        context.startActivity(intent)
    }
}