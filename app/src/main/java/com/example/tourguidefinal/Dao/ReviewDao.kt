package com.example.tourguidefinal.Dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.tourguidefinal.Data.Country
import com.example.tourguidefinal.Data.Review

interface ReviewDao {
    @Query("SELECT * FROM Review WHERE title=:titleValue")
        fun getReviewByTitle(titleValue: String):Review
    fun getAllReview(): LiveData<Review>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertReview(review: Review)
    fun saveReview(Review: Review)

    @Update
    fun updateReview(country: Country):String

    @Delete
    fun deleteReview(review: Review):String

    fun updateReview(country: Review)
}