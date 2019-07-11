package com.example.tourguidefinal.Repository

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

    companion object{
        @Volatile private var instance: ReviewRepository?= null
        fun getInstance(reviewDao: ReviewDao)=
                instance ?: synchronized(this){
                    instance ?: ReviewRepository(reviewDao).also { instance = it }
                }
    }
}