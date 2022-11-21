package com.example.fitnessapplication.Utils

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment

object FragmentManager {
    fun setFragment(newFragment: Fragment, act: AppCompatActivity){
        val transaction = act.supportFragmentManager.beginTransaction()
    }
}