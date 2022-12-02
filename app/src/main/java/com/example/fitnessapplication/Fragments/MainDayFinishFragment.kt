package com.example.fitnessapplication.Fragments

import android.os.Bundle
import android.os.CountDownTimer
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.graphics.drawable.TintAwareDrawable
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.setFragmentResult
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.fitnessapplication.Adapters.ExerciseAdapter
import com.example.fitnessapplication.Utils.FragmentManager
import com.example.fitnessapplication.Utils.MainViewModel
import com.example.fitnessapplication.Utils.TimerUtils
import com.example.fitnessapplication.databinding.ExerciseFragmentBinding
import com.example.fitnessapplication.databinding.ExercisesListFragmentBinding
import com.example.fitnessapplication.databinding.WaitingFragmentBinding


const val COUNT_DOWN_TIMER = 11000L

class MainWaitingFragment: Fragment() {
    private lateinit var binding: WaitingFragmentBinding



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View {
        binding = WaitingFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.progressBar.max = COUNT_DOWN_TIMER.toInt()
        startingTime()
    }

    private fun startingTime() = with(binding){
        timer = object: CountDownTimer(COUNT_DOWN_TIMER, 1){
            override fun onTick(resultTime: Long) {
                textViewTimer.text = TimerUtils.getTime(resultTime)
                progressBar.progress = resultTime.toInt()
            }

            override fun onFinish() {
                FragmentManager.setFragment(MainFragmentExercise.newInstance(), activity as AppCompatActivity)
            }

        }.start()
    }

    override fun onDetach() {
        super.onDetach()
        timer.cancel()
    }

    companion object {
        @JvmStatic
        fun newInstance()  = MainWaitingFragment()

    }
}