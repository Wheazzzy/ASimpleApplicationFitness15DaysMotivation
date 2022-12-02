package com.example.fitnessapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.fragment.app.activityViewModels
import com.example.fitnessapplication.Fragments.MainFragmentDays
import com.example.fitnessapplication.Utils.FragmentManager
import com.example.fitnessapplication.Utils.MainViewModel
import kotlinx.coroutines.Dispatchers.Main

class MainActivity : AppCompatActivity() {
    private val model: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        model.preferences = getSharedPreferences("main", MODE_PRIVATE)
        FragmentManager.setFragment(MainFragmentDays.newInstance(),this)
    }

    override fun onBackPressed() {
        if(FragmentManager.currentFragment is MainFragmentDays) super.onBackPressed()
        else FragmentManager.setFragment(MainFragmentDays.newInstance(), this)

    }
}