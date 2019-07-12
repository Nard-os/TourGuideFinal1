package com.example.tourguidefinal.Data

import androidx.room.Entity

@Entity(tableName = "rates")
data class Rate (val username:String, val userRate: Rate ){
}