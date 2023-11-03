package com.ankit4436.kotlinall.Repository

import androidx.lifecycle.LiveData
import com.ankit4436.kotlinall.Entity.Quote
import com.ankit4436.kotlinall.RoomDatabase.QuoteDao

class QuoteRepository(private val quoteDao: QuoteDao) {

    fun getQuotes(): LiveData<List<Quote>> {
        return quoteDao.getQuotes()
    }

    suspend fun insertQuote(quote: Quote) {
        quoteDao.insertQuotes(quote)
    }

}