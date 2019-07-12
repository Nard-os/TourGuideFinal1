package com.example.tourguidefinal.Repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.tourguidefinal.Dao.ReviewDao
import com.example.tourguidefinal.Data.Review
import com.example.tourguidefinal.Network.TourApiService
import java.net.CacheResponse
import javax.security.auth.callback.Callback

class ReviewRepository(private val reviewDao: ReviewDao) {
    fun getReview() = reviewDao.getAllReview()
    fun getReview(title:String) = reviewDao.getReviewByTitle(title)

    fun insertReview(review: Review){
        reviewDao.insertReview(review)
    }
    fun deleteReview(review: Review){
        reviewDao.deleteReview(review)
    }
    fun updateReview(review: Review){
        reviewDao.updateReview(review)
    }

    fun getReviews(title: String): LiveData<Review> {
        val data = MutableLiveData<Review>()
        TourApiService.findByReviewForAsync(reviewFor).enqueue(object : Callback<Review>){
            override fun onResponse(call: Call<Review>, response: Response<Review>){
                data.value = response.body()
            }
            override fun onFailure(call: Call<Review>, t: Throwable) = Unit
                return data
        }

    }

    fun saveToLocal(review: Review) {
      reviewDao.saveReview(review)
    }

    companion object{
        @Volatile private var instance: ReviewRepository?= null
        fun getInstance(reviewDao: ReviewDao)=
                instance ?: synchronized(this){
                    instance ?: ReviewRepository(reviewDao).also { instance = it }
                }
    }
}