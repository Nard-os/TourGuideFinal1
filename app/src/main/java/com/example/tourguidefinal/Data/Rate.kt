package com.example.tourguidefinal.Data

import androidx.room.Entity

@Entity(tableName = "rates")
data class Rate (val username:Long, val rate:Int){
}