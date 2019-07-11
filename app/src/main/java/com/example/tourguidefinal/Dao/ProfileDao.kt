package com.example.tourguidefinal.Dao

import androidx.room.*
import com.example.tourguidefinal.Data.Profile

@Dao
interface ProfileDao {
    @Query("SELECT * FROM profiles WHERE user_name=:user_name")
    fun getProfileByuser_name(user_name:Long): Profile

    @Insert(onConflict = OnConflictStrategy.REPLACE)
        fun insertusername(profile: Profile):Long

    @Update
    fun updateProfile(profile: Profile): Long
}