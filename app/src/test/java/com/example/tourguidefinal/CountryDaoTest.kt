package com.example.tourguidefinal

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.room.Room
import com.example.tourguidefinal.Data.Country
import com.example.tourguidefinal.Data.Profile
import com.example.tourguidefinal.Database.MyDatabase
import com.example.tourguidefinal.Repository.CountryRepository
import kotlinx.coroutines.runBlocking
import org.hamcrest.CoreMatchers
import org.junit.*

class CountryDaoTest {
    private lateinit var repo: CountryRepository
    private lateinit var database: MyDatabase

    @get:Rule
    var instantExecutorRule = InstantTaskExecutorRule()

    @Before
    fun initDb(){
        database = Room.databaseBuilder(
            ApplicationProvider.getApplication(),
            MyDatabase::class.java,"country"
        ).allowMainThreadQueries().build()
    }

    @After
    fun cleanUp(){
        database.close()
    }

    @Test
    fun insertAndRetrive()= runBlocking {
        val countries = Country("Germany","description description ")
        repo.saveToLocal(countries)
        val result = repo.updateCountry(countries.country_name)

        Assert.assertThat(result, CoreMatchers.notNullValue())
    }



}


