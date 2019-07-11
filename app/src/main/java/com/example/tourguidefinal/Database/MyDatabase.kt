package com.example.tourguidefinal.Database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.tourguidefinal.Dao.CountryDao
import com.example.tourguidefinal.Dao.ProfileDao
import com.example.tourguidefinal.Dao.ReviewDao
import com.example.tourguidefinal.Data.Country
import com.example.tourguidefinal.Data.Profile
import com.example.tourguidefinal.Data.Review

@Database(entities = arrayOf(Profile::class, Review::class, Country::class), version = 1)
abstract class MyDatabase: RoomDatabase() {

    abstract fun profileDao(): ProfileDao
    abstract fun countryDao(): CountryDao
    abstract fun reviewDao(): ReviewDao

 companion object{
     @Volatile
     private var INSTANCE: MyDatabase? = null

     fun getDatabase(context: Context): MyDatabase {

         val tempInstance= INSTANCE
         if (tempInstance != null){
             return tempInstance
         }
         synchronized(this){
             val instance = Room.databaseBuilder(
                 context.applicationContext,
                 MyDatabase::class.java,"tour_database"
             ).build()
             INSTANCE= instance
             return instance
         }
     }
     }
}
