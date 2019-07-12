package com.example.tourguidefinal

import androidx.room.Room
import androidx.test.filters.MediumTest
import androidx.test.runner.AndroidJUnit4
import com.example.tourguidefinal.Data.Review
import com.example.tourguidefinal.Database.MyDatabase
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.hamcrest.CoreMatchers
import org.hamcrest.MatcherAssert
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import kotlin.jvm.java as java1
@ExperimentalCoroutinesApi
@RunWith(AndroidJUnit4::class)
@MediumTest

class ReviewDaoTest {

    private lateinit var database: MyDatabase
    @Before
    fun initDb() {
        // using an in-memory database because the information stored here disappears when the
        // process is killed
        database =
            Room.databaseBuilder(
        ApplicationProvider.getApplicationContext(),
        MyDatabase::class.java,
        ).allowMainThreadQueries().build()
    }

    @After
    fun closeDb() = database.close()
    @Test
    fun saveReviewAndReviewForTest() {
        // GIVEN - insert a group
        val review = Review( "GreeceTour", "@heh ", "it's an amazing place for your next vacation")
        database.reviewDao().saveReview(review.toString())
        // WHEN - Get the group by code from the database
        val loaded = database.reviewDao().getReviewByTitle("Greece Tour")
        // THEN - The loaded data contains the expected values
        MatcherAssert.assertThat(loaded.title, CoreMatchers.`is`(review.title))


    }
}