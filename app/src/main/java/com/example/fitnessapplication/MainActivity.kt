package com.example.fitnessapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.fitnessapplication.Fragments.MainFragmentDays
import com.example.fitnessapplication.Utils.FragmentManager
import kotlinx.coroutines.Dispatchers.Main

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        FragmentManager.setFragment(MainFragmentDays.newInstance(),this)

    }

    override fun onBackPressed() {
        if(FragmentManager.currentFragment is MainFragmentDays) super.onBackPressed()
        else FragmentManager.setFragment(MainFragmentDays.newInstance(), this)

    }
}