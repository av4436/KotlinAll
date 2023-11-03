package com.ankit4436.kotlinall.RoomDatabase

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.ankit4436.kotlinall.Entity.Quote

@Dao
interface QuoteDao {

    @Query("select * from quote")
    fun getQuotes(): LiveData<List<Quote>>

    @Insert
    suspend fun insertQuotes(quote: Quote)


}