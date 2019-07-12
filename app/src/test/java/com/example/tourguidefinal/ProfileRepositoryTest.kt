package com.example.tourguidefinal

import android.provider.ContactsContract
import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.room.Room
import com.example.tourguidefinal.Data.Profile
import com.example.tourguidefinal.Database.MyDatabase
import com.example.tourguidefinal.Repository.ProfileRepository
import kotlinx.android.synthetic.main.fragment_signup.*
import kotlinx.coroutines.runBlocking
import org.hamcrest.CoreMatchers
import org.junit.*

class ProfileRepositoryTest {
    private lateinit var repo: profileRepository
    private lateinit var database: MyDatabase

    @get:Rule
    var instantExecutorRule = InstantTaskExecutorRule()

    @Before
    fun setup(){
        database = Room.databaseBuilder(
            ApplicationProvider.getApplicationContext(),
            MyDatabase::class.java,
            "Profile"
        ).allowMainThreadQueries().build()
        repo = ProfileRepository(database.profileDao())}
    @After
    fun cleanUp(){
        database.close()
    }
@Test
fun insertAndRetrive()= runBlocking {
    val profile = Profile("@nardi" , "Nardos","nardi@gmail.com" )
    repo.saveToLocal(profile)

    val result = repo.signup_button(profile.user_name)

    Assert.assertThat(result, CoreMatchers.notNullValue())
}

}