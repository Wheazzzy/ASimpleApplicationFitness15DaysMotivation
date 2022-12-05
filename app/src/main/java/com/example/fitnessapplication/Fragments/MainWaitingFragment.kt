package com.example.fitnessapplication.Fragments

import android.os.Bundle
import android.os.CountDownTimer
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.fitnessapplication.R
import com.example.fitnessapplication.Utils.FragmentManager
import com.example.fitnessapplication.Utils.TimerUtils
import com.example.fitnessapplication.databinding.WaitingFragmentBinding


const val COUNT_DOWN_TIMER = 6000L

class MainWaitingFragment : Fragment() {
    private lateinit var binding: WaitingFragmentBinding
    private lateinit var timer: CountDownTimer
    private var actionBar: ActionBar? = null


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = WaitingFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        actionBar = (activity as AppCompatActivity).supportActionBar
        actionBar?.title = getString(R.string.waiting)
        binding.progressBar.max = COUNT_DOWN_TIMER.toInt()
        startingTime()
    }

    private fun startingTime() = with(binding) {
        timer = object : CountDownTimer(COUNT_DOWN_TIMER, 1) {
            override fun onTick(resultTime: Long) {
                textViewTimer.text = TimerUtils.getTime(resultTime)
                progressBar.progress = resultTime.toInt()
            }

            override fun onFinish() {
                FragmentManager.setFragment(
                    MainFragmentExercise.newInstance(),
                    activity as AppCompatActivity
                )
            }

        }.start()
    }

    override fun onDetach() {
        super.onDetach()
        timer.cancel()
    }

    companion object {
        @JvmStatic
        fun newInstance() = MainWaitingFragment()

    }
}