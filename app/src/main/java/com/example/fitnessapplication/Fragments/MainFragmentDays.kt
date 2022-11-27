package com.example.fitnessapplication.Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.fitnessapplication.Adapters.DayAdapter
import com.example.fitnessapplication.Adapters.DayModel
import com.example.fitnessapplication.Adapters.ExerciseModel
import com.example.fitnessapplication.R
import com.example.fitnessapplication.Utils.MainViewModel
import com.example.fitnessapplication.databinding.ExercisesListFragmentBinding
import com.example.fitnessapplication.databinding.FragmentMainDaysBinding


class MainFragmentDays: Fragment(), DayAdapter.Listener {
    private lateinit var binding: FragmentMainDaysBinding
    private val model: MainViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View {
        binding = FragmentMainDaysBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initializationRecyclerView()
    }

    private fun initializationRecyclerView() = with(binding){
        var adapter = DayAdapter(this@MainFragmentDays)
        recyclerViewDays.layoutManager = LinearLayoutManager(activity as AppCompatActivity)
        recyclerViewDays.adapter = adapter
        adapter.submitList(fillDaysArray())
    }

    private fun fillDaysArray(): ArrayList<DayModel>{
        val tempArray = ArrayList<DayModel>()
        resources.getStringArray(R.array.exercise_days).forEach {
            tempArray.add(DayModel(it, false))
        }
        return tempArray
    }

    private fun fillExerciseList(days: DayModel){
        val tempList = ArrayList<ExerciseModel>()
        days.exercises.split(",").forEach{
            val exerciseList = resources.getStringArray(R.array.training_exercise)
            val exercise = exerciseList[it.toInt()]
            val exerciseArrays = exercise.split("|")
            tempList.add(ExerciseModel(exerciseArrays[0], exerciseArrays[1], exerciseArrays[2]))
        }

    }

    companion object {
        @JvmStatic
        fun newInstance()  = MainFragmentDays()

    }

    override fun onClick(days: DayModel) {
       com.example.fitnessapplication.Utils.FragmentManager.setFragment(MainFragmentExerciseList.newInstance(), activity as AppCompatActivity)
    }
}