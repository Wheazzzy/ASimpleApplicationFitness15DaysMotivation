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
import com.example.fitnessapplication.Adapters.ExerciseModel
import com.example.fitnessapplication.Utils.FragmentManager
import com.example.fitnessapplication.Utils.MainViewModel
import com.example.fitnessapplication.databinding.ExerciseFragmentBinding
import com.example.fitnessapplication.databinding.ExercisesListFragmentBinding
import com.example.fitnessapplication.databinding.WaitingFragmentBinding
import pl.droidsonroids.gif.GifDrawable


class MainFragmentExercise: Fragment() {
    private lateinit var binding: ExerciseFragmentBinding
    private val model: MainViewModel by activityViewModels()
    private var exerciseCounter = 0
    private var exerciseList: ArrayList<ExerciseModel>? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View {
        binding = ExerciseFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        model.mutableExerciseList.observe(viewLifecycleOwner){
            exerciseList = it
        }

    }

    private fun nextExercise(){
        if(exerciseCounter > exerciseList?.size!!){
            val exersize = exerciseList?.get(exerciseCounter++)
            showExercise(exersize)
        }else{

        }
    }

    private fun showExercise(exerciseModel: ExerciseModel?) = with(binding){
        if(exerciseModel == null)
            return@with
        imageViewMain.setImageDrawable(GifDrawable(root.context.assets, exerciseModel.image))
    }

    companion object {
        @JvmStatic
        fun newInstance()  = MainFragmentExercise()

    }
}