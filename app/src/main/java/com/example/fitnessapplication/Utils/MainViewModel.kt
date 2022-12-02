package com.example.fitnessapplication.Utils

import android.content.SharedPreferences
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.fitnessapplication.Adapters.ExerciseModel

class MainViewModel: ViewModel() {
    val mutableExerciseList = MutableLiveData<ArrayList<ExerciseModel>>()
    val preferences: SharedPreferences? = null

    fun savePreferences(key: String, exerciseCounter: Int){
        preferences?.edit()?.putInt(key, exerciseCounter)?.apply()
    }
}