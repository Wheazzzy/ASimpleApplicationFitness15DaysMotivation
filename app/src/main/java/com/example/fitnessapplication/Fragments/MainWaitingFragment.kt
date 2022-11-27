package com.example.fitnessapplication.Fragments

import android.os.Bundle
import android.os.CountDownTimer
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.fitnessapplication.Adapters.ExerciseAdapter
import com.example.fitnessapplication.Utils.MainViewModel
import com.example.fitnessapplication.databinding.ExercisesListFragmentBinding


const val COUNT_DOWN_TIMER = 11000L

class MainWaitingFragment: Fragment() {
    private lateinit var binding: ExercisesListFragmentBinding
    private lateinit var timer: CountDownTimer


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View {
        binding = ExercisesListFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }

    private fun startingTime() = with(binding){
        timer = object: CountDownTimer(COUNT_DOWN_TIMER, 100){
            override fun onTick(p0: Long) {

            }

            override fun onFinish() {

            }

        }
    }

    companion object {
        @JvmStatic
        fun newInstance()  = MainWaitingFragment()

    }
}