package com.ankit4436.kotlinall.DataBinding

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.ankit4436.kotlinall.R
import com.ankit4436.kotlinall.databinding.ActivityMainShowBinding

class MainShowActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainShowBinding
    lateinit var dataViewModel: DataViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main_show)
        dataViewModel = ViewModelProvider(this).get(DataViewModel::class.java)

        dataViewModel.quoteLivedata.observe(this,{
            binding.quatetext.text=it
        })

      /*  binding.btnUpdate.setOnClickListener{
            dataViewModel.updateQuoue()
        }*/

      //  binding.dataViewModel=dataViewModel
    }
}