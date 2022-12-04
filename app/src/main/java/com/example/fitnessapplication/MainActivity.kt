package com.example.fitnessapplication

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.fitnessapplication.Fragments.MainFragmentDays
import com.example.fitnessapplication.Utils.ConnectivityObserver
import com.example.fitnessapplication.Utils.FragmentManager
import com.example.fitnessapplication.Utils.MainViewModel
import com.example.fitnessapplication.Utils.NetworkConnectivityObserver

class MainActivity : AppCompatActivity() {
    private val model: MainViewModel by viewModels()
    private lateinit var connectivityObserver: ConnectivityObserver


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        connectivityObserver = NetworkConnectivityObserver(applicationContext)
        setContentView(R.layout.activity_main)
        model.preferences = getSharedPreferences("main", MODE_PRIVATE)
        FragmentManager.setFragment(MainFragmentDays.newInstance(), this)

    }

    override fun onBackPressed() {
        if (FragmentManager.currentFragment is MainFragmentDays) super.onBackPressed()
        else FragmentManager.setFragment(MainFragmentDays.newInstance(), this)

    }
}