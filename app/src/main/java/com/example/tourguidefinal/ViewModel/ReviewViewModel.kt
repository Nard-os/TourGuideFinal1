package com.example.tourguidefinal.ViewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.tourguidefinal.Data.Review
import com.example.tourguidefinal.Repository.ReviewRepository

class ReviewViewModel(
    private val reviewRepository: ReviewRepository,
    private val title: String

): ViewModel() {
    val review: LiveData<Review>
    init {
        review = reviewRepository.getReview(title)
    }
}