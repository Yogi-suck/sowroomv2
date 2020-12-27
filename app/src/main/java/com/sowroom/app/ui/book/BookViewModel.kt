package com.sowroom.app.ui.book

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sowroom.app.data.model.ActionState
import com.sowroom.app.data.model.Book
import com.sowroom.app.data.repository.BookRepository
import kotlinx.coroutines.launch

class BookViewModel : ViewModel() {
    private val repo: BookRepository by lazy { BookRepository() }

    val loading= MutableLiveData(false)
    val actionState= MutableLiveData<ActionState<*>>()

    val listResp= MutableLiveData<List<Book>>()
    val detailResp= MutableLiveData<Book>()
    val searchResp= MutableLiveData<List<Book>>()

    val url = MutableLiveData("")
    val query = MutableLiveData("")

    fun listBook() {
        viewModelScope.launch {
            loading.value = true
            val resp = repo.listBook()
            actionState.value = resp
            listResp.value= resp.data
            loading.value = false
        }
    }

    fun detailBook(url: String? = this.url.value) {
        url?.let {
            viewModelScope.launch {
                loading.value = true
                val resp = repo.detailBook(it)
                actionState.value = resp
                detailResp.value = resp.data
                loading.value = false
            }
        }
    }

    fun searchBook(query: String? = this.url.value){
        query?.let {
            viewModelScope.launch {
                loading.value = true
                val resp = repo.searchBook(it)
                actionState.value = resp
                searchResp.value = resp.data
                loading.value = false
            }
        }
    }
}