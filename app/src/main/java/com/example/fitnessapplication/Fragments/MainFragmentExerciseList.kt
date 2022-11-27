package com.example.fitnessapplication.Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.example.fitnessapplication.Utils.MainViewModel
import com.example.fitnessapplication.databinding.ExercisesListFragmentBinding
import com.example.fitnessapplication.databinding.FragmentMainDaysBinding


class MainFragmentExerciseList: Fragment() {
    private lateinit var binding: ExercisesListFragmentBinding
    private val model: MainViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View {
        binding = ExercisesListFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        model.mutableExerciseList.observe(viewLifecycleOwner){

        }
    }

    companion object {
        @JvmStatic
        fun newInstance()  = MainFragmentExerciseList()

    }
}