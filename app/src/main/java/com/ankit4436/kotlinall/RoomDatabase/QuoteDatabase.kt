package com.ankit4436.kotlinall.RoomDatabase

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.ankit4436.kotlinall.Entity.Quote

@Database(entities = [Quote::class], version = 1)
abstract class QuoteDatabase:RoomDatabase() {

    abstract fun quoteDao() : QuoteDao

    companion object{
        private var INSTANSE : QuoteDatabase?=null

        fun getDatabase(context:Context):QuoteDatabase{
            if (INSTANSE==null){
                synchronized(this){
                    INSTANSE= Room.databaseBuilder(context,
                        QuoteDatabase::class.java,
                        "quote_database"
                    ).build()
                }
            }
            return INSTANSE!!
        }
    }
}