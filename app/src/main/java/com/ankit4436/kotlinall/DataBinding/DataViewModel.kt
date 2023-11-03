package com.ankit4436.kotlinall.DataBinding

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class DataViewModel : ViewModel() {

    val quoteLivedata=MutableLiveData("Hello Dear Friends")

    fun updateQuoue(){
        quoteLivedata.value="Now data is updated"
    }


}