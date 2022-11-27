package com.example.fitnessapplication.Utils

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.fitnessapplication.Adapters.ExerciseModel

class MainViewModel: ViewModel() {
    val mutableExerciseList = MutableLiveData<ArrayList<ExerciseModel>>()
}