package com.example.tourguidefinal.Dao

import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.tourguidefinal.Data.Review

interface ReviewDao {
    @Query("SELECT * FROM Review WHERE title=:titleValue")
        fun getReviewByTitle(titleValue: String):Review
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun saveReview(Review: String)
}