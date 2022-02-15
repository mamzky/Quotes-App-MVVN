package com.example.quoteapp.data

class QuoteRepository private constructor(private val quoteDao: FakeQuoteDao) {


    fun addQuote(quote: Quote){
        quoteDao.addQuote(quote)
    }

    fun getQuotes() = quoteDao.getQuotes()

    companion object {
        // @Volatile - Writes to this property are immediately visible to other threads
        @Volatile private var instance: QuoteRepository? = null

        // The only way to get hold of the FakeDatabase object
        fun getInstance(quoteDao: FakeQuoteDao) =
        // Already instantiated? - return the instance
            // Otherwise instantiate in a thread-safe manner
            instance ?: synchronized(this) {
                // If it's still not instantiated, finally create an object
                // also set the "instance" property to be the currently created one
                instance ?: QuoteRepository(quoteDao).also { instance = it }
            }
    }

}