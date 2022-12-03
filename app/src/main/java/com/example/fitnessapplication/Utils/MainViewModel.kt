package com.example.fitnessapplication.Utils

import android.content.SharedPreferences
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.fitnessapplication.Adapters.ExerciseModel

class MainViewModel : ViewModel() {
    val mutableExerciseList = MutableLiveData<ArrayList<ExerciseModel>>()
    var preferences: SharedPreferences? = null
    var currentDay = 0

    fun savePreferences(key: String, exerciseCounter: Int) {
        preferences?.edit()?.putInt(key, exerciseCounter)?.apply()
    }

    fun getExerciseCounter(): Int {
        return preferences?.getInt(currentDay.toString(), 0) ?: 0
    }
}