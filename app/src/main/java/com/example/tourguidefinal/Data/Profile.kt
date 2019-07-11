package com.example.tourguidefinal.Data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity(tableName = "profiles")
data class Profile (
    @PrimaryKey @ColumnInfo(name = "user_name") val user_name:String,
    @ColumnInfo(name = "name") val name: String,
    @ColumnInfo(name = "email") val email:Long,
    @ColumnInfo(name="country")val country: String,
    @ColumnInfo(name = "password") val password:Long)
    :Serializable