package com.example.tourguidefinal.ViewModel

import android.app.Application
import androidx.databinding.Bindable
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.tourguidefinal.Repository.RateRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.util.*

class RateViewModel(application: Application):AndroidViewModel(application),Observable {
    private val rateRepository: RateRepository

    init {
        rateRepository = RateRepository()
    }
    @Bindable
    val userRateBind = MutableLiveData<String>()

    val rate = userRateBind.value?.toInt()
    val userRate = rate as Int

    fun onRateButtonClicked()= viewModelScope.launch ( Dispatchers .IO ) {
        rateRepository.saveRate(Rate(OL,userRate))
    }
}

 fun onDeleteButtonClicked()= viewModelIscope.launch(Dispatchers.IO) {
     if(userRate <=5){
         rateRepository.deleteRate(userRate)
     }

 }
