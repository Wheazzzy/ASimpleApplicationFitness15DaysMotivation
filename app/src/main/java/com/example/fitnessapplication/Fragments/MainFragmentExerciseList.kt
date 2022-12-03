package com.example.fitnessapplication.Fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.fitnessapplication.Adapters.ExerciseAdapter
import com.example.fitnessapplication.R
import com.example.fitnessapplication.Utils.FragmentManager
import com.example.fitnessapplication.Utils.MainViewModel
import com.example.fitnessapplication.databinding.ExercisesListFragmentBinding


class MainFragmentExerciseList : Fragment() {
    private lateinit var binding: ExercisesListFragmentBinding
    private lateinit var adapter: ExerciseAdapter
    private var actionBar: ActionBar? = null
    private val model: MainViewModel by activityViewModels()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = ExercisesListFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initialization()
        actionBar = (activity as AppCompatActivity).supportActionBar
        actionBar?.title = getString(R.string.exercise)
        model.mutableExerciseList.observe(viewLifecycleOwner) {
            for (i in 0 until model.getExerciseCounter()) {
                it[i] = it[i].copy(isDone = true)
            }
            adapter.submitList(it)
        }
    }

    private fun initialization() = with(binding) {
        adapter = ExerciseAdapter()
        recyclerView.layoutManager = LinearLayoutManager(activity)
        recyclerView.adapter = adapter
        buttonStart.setOnClickListener {
            FragmentManager.setFragment(
                MainWaitingFragment.newInstance(),
                activity as AppCompatActivity
            )
        }
    }

    companion object {
        @JvmStatic
        fun newInstance() = MainFragmentExerciseList()

    }
}