package com.example.quoteapp.ui.quotes

import androidx.lifecycle.ViewModel
import com.example.quoteapp.data.Quote
import com.example.quoteapp.data.QuoteRepository

class QuotesViewModel(private val quoteRepository: QuoteRepository): ViewModel() {

    fun getQuotes() = quoteRepository.getQuotes()

    fun addQuotes(quote : Quote) = quoteRepository.addQuote(quote)


}