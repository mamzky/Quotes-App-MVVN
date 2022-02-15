package com.example.quoteapp.utilities

import com.example.quoteapp.data.FakeDatabase
import com.example.quoteapp.data.QuoteRepository
import com.example.quoteapp.ui.quotes.QuotesViewModelFactory

object InjectorUtils {

    fun provideQuotesViewModelFactory(): QuotesViewModelFactory{

        val quoteRepository = QuoteRepository.getInstance(FakeDatabase.getInstance().quoteDao )
        return QuotesViewModelFactory(quoteRepository)
    }
}