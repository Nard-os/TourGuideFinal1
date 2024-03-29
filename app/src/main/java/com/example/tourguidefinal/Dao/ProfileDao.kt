package com.example.tourguidefinal.Dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.tourguidefinal.Data.Profile

@Dao
interface ProfileDao {
    @Query("SELECT * FROM profiles WHERE user_name=:user_name")
    fun getProfilessByuser_name(user_name:Long): Profile
    fun getAllProfiles(username: String.Companion):LiveData<Profile>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
        fun insertusername(profile: Profile):String

    @Update
    fun updateProfile(profile: Profile): String

    abstract fun deleteProfile(profile: Profile)
    fun insertProfiles(profile: Profile)
    fun getProfile(username: String): Any
}