package com.example.fitnessapplication.Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.fitnessapplication.Adapters.ExerciseAdapter
import com.example.fitnessapplication.Utils.MainViewModel
import com.example.fitnessapplication.databinding.ExercisesListFragmentBinding
import com.example.fitnessapplication.databinding.FragmentMainDaysBinding


class MainFragmentExerciseList: Fragment() {
    private lateinit var binding: ExercisesListFragmentBinding
    private val model: MainViewModel by activityViewModels()
    private lateinit var adapter: ExerciseAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View {
        binding = ExercisesListFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initialization()
        model.mutableExerciseList.observe(viewLifecycleOwner){
            adapter.submitList(it)
        }
    }

    private fun initialization() = with(binding){
        adapter = ExerciseAdapter()
        recyclerView.layoutManager = LinearLayoutManager(activity)
        recyclerView.adapter = adapter
    }

    companion object {
        @JvmStatic
        fun newInstance()  = MainFragmentExerciseList()

    }
}