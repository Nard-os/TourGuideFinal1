package com.example.tourguidefinal

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.room.Room
import com.example.tourguidefinal.Data.Country
import com.example.tourguidefinal.Data.Profile
import com.example.tourguidefinal.Database.MyDatabase
import com.example.tourguidefinal.Repository.CountryRepository
import com.example.tourguidefinal.Repository.ProfileRepository
import kotlinx.coroutines.runBlocking
import org.hamcrest.CoreMatchers
import org.junit.*

class CountryRepositoryTest {
    private lateinit var repo: CountryRepository
    private lateinit var database: MyDatabase

    @get:Rule
    var instantExecutorRule = InstantTaskExecutorRule()

    @Before
    fun setup(){
        database = Room.databaseBuilder(
            ApplicationProvider.getApplicationContext(),
            MyDatabase::class.java,
            "Country"
        ).allowMainThreadQueries().build()
        repo = CountryRepository(database.countryDao())
    }
    @After
    fun cleanUp(){
        database.close()
    }

    @Test
    fun insertAndRetrive()= runBlocking {
        val countries = Country("Greece" , "an amazing place for your next vacation with lots of amazing natural n man made touches" )
        repo.saveToLocal(countries)

        val result = repo.updateCountry(countries.country_name)

        Assert.assertThat(result, CoreMatchers.notNullValue())
    }

}