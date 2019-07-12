package com.example.tourguidefinal.Repository

import com.example.tourguidefinal.Network.TourApiService

class RateRepository {

    private val TourApiService = ApiService.getInstance()

    fun saveRate(rateSaved: rate) {
        TourApiService.saveRateAsync(rateSaved)

    }

    fun deleteRate(userRate: Int){
        TourApiService.deleteRate(userRate)
    }
}