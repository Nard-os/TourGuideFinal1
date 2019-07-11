package com.example.tourguidefinal.Data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "countries")
data class Country (
    @PrimaryKey @ColumnInfo(name = "country_name") val CountryName:String,
    @ColumnInfo (name="country_description") val description:Long)
