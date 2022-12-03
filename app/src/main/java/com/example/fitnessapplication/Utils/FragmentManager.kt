package com.example.fitnessapplication.Utils

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.fitnessapplication.R

object FragmentManager {
    var currentFragment: Fragment? = null

    fun setFragment(newFragment: Fragment, act: AppCompatActivity) {
        val transaction = act.supportFragmentManager.beginTransaction()
        transaction.setCustomAnimations(android.R.anim.fade_in, android.R.anim.fade_out)
        transaction.replace(R.id.place_holder, newFragment)
        transaction.commit()
        currentFragment = newFragment
    }
}