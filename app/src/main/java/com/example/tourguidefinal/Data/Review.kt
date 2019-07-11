package com.example.tourguidefinal.Data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Review(@PrimaryKey(autoGenerate = true)val title:String, val username:Long, val description:Long){
}