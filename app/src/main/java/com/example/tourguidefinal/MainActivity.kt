package com.example.tourguidefinal

import android.os.AsyncTask
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.tourguidefinal.Dao.CountryDao
import com.example.tourguidefinal.Dao.ProfileDao
import com.example.tourguidefinal.Dao.ReviewDao
import com.example.tourguidefinal.Database.MyDatabase
import com.example.tourguidefinal.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
  private lateinit var myDatabase: MyDatabase
    private lateinit var profileDao: ProfileDao
    private lateinit var countryDao: CountryDao
    private lateinit var reviewDao: ReviewDao

private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        AsyncTask.execute{
        myDatabase= MyDatabase.getDatabase(this)
        profileDao = myDatabase.profileDao()
        countryDao = myDatabase.countryDao()
        reviewDao = myDatabase.reviewDao()}
    }
}
