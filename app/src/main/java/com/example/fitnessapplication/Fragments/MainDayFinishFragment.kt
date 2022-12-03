package com.example.fitnessapplication.Fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.fitnessapplication.R
import com.example.fitnessapplication.Utils.FragmentManager
import com.example.fitnessapplication.databinding.DayFinishFragmentBinding
import pl.droidsonroids.gif.GifDrawable


class MainDayFinishFragment : Fragment() {
    private lateinit var binding: DayFinishFragmentBinding
    private var actionBar: ActionBar? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DayFinishFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        actionBar = (activity as AppCompatActivity).supportActionBar
        actionBar?.title = getString(R.string.done)
        binding.imageViewMain.setImageDrawable(
            GifDrawable(
                (activity as AppCompatActivity).assets,
                "Congratulations.gif"
            )
        )
        binding.buttonDone.setOnClickListener {
            FragmentManager.setFragment(
                MainFragmentDays.newInstance(),
                activity as AppCompatActivity
            )
        }
    }

    companion object {
        @JvmStatic
        fun newInstance() = MainDayFinishFragment()

    }
}