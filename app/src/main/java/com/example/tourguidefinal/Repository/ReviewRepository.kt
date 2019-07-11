package com.example.tourguidefinal.Repository

import androidx.lifecycle.LiveData
import com.example.tourguidefinal.Dao.ReviewDao
import com.example.tourguidefinal.Data.Review

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
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    companion object{
        @Volatile private var instance: ReviewRepository?= null
        fun getInstance(reviewDao: ReviewDao)=
                instance ?: synchronized(this){
                    instance ?: ReviewRepository(reviewDao).also { instance = it }
                }
    }
}