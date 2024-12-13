package com.plcoding.bookpedia.book.presentation

import androidx.lifecycle.ViewModel
import com.plcoding.bookpedia.book.domain.Place
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class SelectedBookViewModel: ViewModel() {

    private val _selectedBook = MutableStateFlow<Place?>(null)
    val selectedBook = _selectedBook.asStateFlow()

    fun onSelectBook(book: Place?) {
        _selectedBook.value = book
    }
}