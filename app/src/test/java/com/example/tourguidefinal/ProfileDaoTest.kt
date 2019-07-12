package com.example.tourguidefinal

import androidx.room.Room
import androidx.test.filters.MediumTest
import androidx.test.runner.AndroidJUnit4
import com.example.tourguidefinal.Database.MyDatabase
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@ExperimentalCoroutinesApi
@RunWith(AndroidJUnit4::class)
@MediumTest

class ProfileDaoTest {
    private lateinit var database: MyDatabase


    @Before
    fun initDb(){
        database = Room.databaseBuilder(
            ApplicationProvider.getApplication(),
            MyDatabase::class.java,"profile"
            ).allowMainThreadQueries().build()
    }

    @After
    fun closeDb() = database.close()

    @Test
    fun getProfileByUserNameAndSaveProfile_test() = runBlocking {
        val profile = Profile("nina1"," nina@gmail.com", "huru7" )
        database.profileDao().saveProfile(profile.username)
        val loaded = database.profileDao().getProfilessByuser_name(profile.username)
    }
    }
}