package com.example.fitnessapplication.Fragments

import android.os.Bundle
import android.os.CountDownTimer
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.graphics.drawable.TintAwareDrawable
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.fitnessapplication.Adapters.ExerciseAdapter
import com.example.fitnessapplication.Utils.MainViewModel
import com.example.fitnessapplication.Utils.TimerUtils
import com.example.fitnessapplication.databinding.ExercisesListFragmentBinding
import com.example.fitnessapplication.databinding.WaitingFragmentBinding


const val COUNT_DOWN_TIMER = 11000L

class MainWaitingFragment: Fragment() {
    private lateinit var binding: WaitingFragmentBinding
    private lateinit var timer: CountDownTimer


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View {
        binding = WaitingFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.progressBar.max = COUNT_DOWN_TIMER.toInt()

    }

    private fun startingTime() = with(binding){
        timer = object: CountDownTimer(COUNT_DOWN_TIMER, 100){
            override fun onTick(resultTime: Long) {
                textViewTimer.text = TimerUtils.getTime(resultTime)
                progressBar.progress = resultTime.toInt()
            }

            override fun onFinish() {

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