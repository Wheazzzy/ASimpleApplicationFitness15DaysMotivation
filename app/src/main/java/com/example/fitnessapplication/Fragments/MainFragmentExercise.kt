package com.example.fitnessapplication.Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.fitnessapplication.Adapters.ExerciseAdapter
import com.example.fitnessapplication.Utils.FragmentManager
import com.example.fitnessapplication.Utils.MainViewModel
import com.example.fitnessapplication.databinding.ExercisesListFragmentBinding
import com.example.fitnessapplication.databinding.WaitingFragmentBinding


class MainFragmentExercise: Fragment() {
    private lateinit var binding: ExercisesListFragmentBinding
    private lateinit var adapter: ExerciseAdapter

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
            adapter.submitList(it)
        }
        initialization()
    }

    private fun initialization() = with(binding){
        adapter = ExerciseAdapter()
        recyclerView.layoutManager = LinearLayoutManager(activity)
        recyclerView.adapter = adapter
        buttonStart.setOnClickListener{
            FragmentManager.setFragment(MainWaitingFragment.newInstance(), activity as AppCompatActivity)
        }
    }

    companion object {
        @JvmStatic
        fun newInstance()  = MainFragmentExercise()

    }
}