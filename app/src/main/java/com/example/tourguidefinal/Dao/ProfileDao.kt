package com.example.tourguidefinal.Dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.tourguidefinal.Data.Profile

@Dao
interface ProfileDao {
    @Query("SELECT * FROM profiles WHERE user_name=:user_name")
    fun getProfilesByuser_name(user_name:Long): Profile
    fun getAllProfiles(username: Long.Companion):LiveData<Profile>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
        fun insertusername(profile: Profile):Long

    @Update
    fun updateProfile(profile: Profile): Long

    abstract fun deleteProfile(profile: Profile)
    fun insertProfiles(profile: Profile)
    fun getProfile(username: Long): Any
}