package com.ankit4436.kotlinall

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.ankit4436.kotlinall.Entity.Quote
import com.ankit4436.kotlinall.Repository.QuoteRepository
import com.ankit4436.kotlinall.RoomDatabase.QuoteDatabase
import com.ankit4436.kotlinall.ViewModel.MainViewModel
import com.ankit4436.kotlinall.ViewModel.MainViewModelFactory
import com.ankit4436.kotlinall.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    lateinit var mainViewModel: MainViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        val dao = QuoteDatabase.getDatabase(applicationContext).quoteDao()
        val repository = QuoteRepository(dao)
//Hello ankit
        mainViewModel =
            ViewModelProvider(this, MainViewModelFactory(repository)).get(MainViewModel::class.java)

        mainViewModel.getQuotes().observe(this, {
            binding.quotes = it.toString()
        })

        binding.btnAddQuote.setOnClickListener {
            val quote = Quote(0, "Hii Ankit", "Ankit Verma")
            mainViewModel.insertQuote(quote)
        }


    }
}