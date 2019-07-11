package com.example.tourguidefinal.Dao

import androidx.room.*
import com.example.tourguidefinal.Data.Country

@Dao
interface CountryDao {
    @Query("SELECT * FROM countries WHERE country_name = :CountryName LIMIT 1")
    fun getCountryByCountryName(CountryName:String):Country

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertCountry(country: Country):String

    @Update
    fun updateCountry(country: Country):String

    @Delete
    fun deleteCountry(country: Country):String

}
