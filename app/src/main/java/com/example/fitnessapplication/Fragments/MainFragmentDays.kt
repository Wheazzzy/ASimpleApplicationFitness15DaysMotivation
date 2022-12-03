package com.example.fitnessapplication.Fragments

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.fitnessapplication.Adapters.DayAdapter
import com.example.fitnessapplication.Adapters.DayModel
import com.example.fitnessapplication.Adapters.ExerciseModel
import com.example.fitnessapplication.R
import com.example.fitnessapplication.Utils.FragmentManager
import com.example.fitnessapplication.Utils.MainViewModel
import com.example.fitnessapplication.databinding.FragmentMainDaysBinding


class MainFragmentDays: Fragment(), DayAdapter.Listener {
    private lateinit var binding: FragmentMainDaysBinding
    private val model: MainViewModel by activityViewModels()
    private var actionBar: ActionBar? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View {
        binding = FragmentMainDaysBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        model.currentDay = 0
        initializationRecyclerView()
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        return inflater.inflate(R.menu.main_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        return super.onOptionsItemSelected(item)

    }

    private fun initializationRecyclerView() = with(binding){
        val adapter = DayAdapter(this@MainFragmentDays)
        actionBar = (activity as AppCompatActivity).supportActionBar
        actionBar?.title = getString(R.string.days)
        recyclerViewDays.layoutManager = LinearLayoutManager(activity as AppCompatActivity)
        recyclerViewDays.adapter = adapter
        adapter.submitList(fillDaysArray())
    }

    private fun fillDaysArray(): ArrayList<DayModel>{
        val tempArray = ArrayList<DayModel>()
        var daysDoneCounter = 0
        resources.getStringArray(R.array.exercise_days).forEach {
            model.currentDay++
            val exerciseCounter = it.split(",").size
            tempArray.add(DayModel(it, 0,model.getExerciseCounter() == exerciseCounter))
        }
        binding.progressBar2.max = tempArray.size
        tempArray.forEach{
            if(it.isDone) daysDoneCounter++
        }
        updateRestDaysUI(tempArray.size - daysDoneCounter, tempArray.size)
        return tempArray
    }

    private fun updateRestDaysUI(restDays: Int, days: Int) = with(binding){
        val rDays = getString(R.string.rest) + " $restDays " + getString(R.string.rest_days)
        textViewDays.text = rDays
        progressBar2.progress = days - restDays
    }

    private fun fillExerciseList(days: DayModel){
        val tempList = ArrayList<ExerciseModel>()
        days.exercises.split(",").forEach{
            val exerciseList = resources.getStringArray(R.array.training_exercise)
            val exercise = exerciseList[it.toInt()]
            val exerciseArrays = exercise.split("|")
            tempList.add(ExerciseModel(exerciseArrays[0], exerciseArrays[1], false, exerciseArrays[2]))
        }
        model.mutableExerciseList.value = tempList
    }

    companion object {
        @JvmStatic
        fun newInstance()  = MainFragmentDays()
    }

    override fun onClick(days: DayModel) {
        fillExerciseList(days)
        model.currentDay = days.dayNumber
       FragmentManager.setFragment(MainFragmentExerciseList.newInstance(), activity as AppCompatActivity)
    }
 }