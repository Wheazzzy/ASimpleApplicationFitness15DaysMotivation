package com.example.fitnessapplication.Fragments

import android.os.Bundle
import android.os.CountDownTimer
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.fitnessapplication.Adapters.ExerciseAdapter
import com.example.fitnessapplication.Adapters.ExerciseModel
import com.example.fitnessapplication.R
import com.example.fitnessapplication.Utils.FragmentManager
import com.example.fitnessapplication.Utils.MainViewModel
import com.example.fitnessapplication.Utils.TimerUtils
import com.example.fitnessapplication.databinding.ExerciseFragmentBinding
import com.example.fitnessapplication.databinding.ExercisesListFragmentBinding
import com.example.fitnessapplication.databinding.WaitingFragmentBinding
import pl.droidsonroids.gif.GifDrawable


class MainFragmentExercise: Fragment() {
    private var timer: CountDownTimer? = null
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
            nextExercise()
        }
        binding.buttonNext.setOnClickListener{
            nextExercise()
        }
    }

    private fun nextExercise(){
        if(exerciseCounter < exerciseList?.size!!){
            val exersize = exerciseList?.get(exerciseCounter++)?: return
            showExercise(exersize)
            setExerciseType(exersize)
            showNextExercise()
        }else{
            Toast.makeText(activity, "DONE", Toast.LENGTH_LONG).show()
        }
    }

    private fun showExercise(exerciseModel: ExerciseModel) = with(binding){
        imageViewMain.setImageDrawable(GifDrawable(root.context.assets, exerciseModel.image))
        textViewName.text = exerciseModel.name
    }

    private fun setExerciseType(exercise: ExerciseModel){
        if(exercise.time.startsWith("x")){
            binding.textViewTimeCount.text = exercise.time
        }else{
            startingTime(exercise)
        }
    }

    private fun showNextExercise() = with(binding){
        if(exerciseCounter < exerciseList?.size!!){
            val exersize = exerciseList?.get(exerciseCounter)?: return
            imageMainNext.setImageDrawable(GifDrawable(root.context.assets, exersize.image))
            setTimeType(exersize)
            textViewNextName.text = exersize.name
        }else{
            imageMainNext.setImageDrawable(GifDrawable(root.context.assets,"Congratulations.gif"))
            textViewNextName.text = getString(R.string.done)
        }
    }

    private fun setTimeType(exercise: ExerciseModel){
        if(exercise.time.startsWith("x")){
            binding.textViewNextName.text = exercise.time
        }else{
            val name = exercise.name + ": ${TimerUtils.getTime(exercise.time.toLong() * 1000)}"
            binding.textViewNextName.text = name
        }
    }

    private fun startingTime(ex: ExerciseModel) = with(binding){
        progressBarMain.max = ex.time.toInt() * 1000
        timer?.cancel()
        timer = object: CountDownTimer(ex.time.toLong() * 1000, 1){

            override fun onTick(resultTime: Long) {
                textViewTimeCount.text = TimerUtils.getTime(resultTime)
                progressBarMain.progress = resultTime.toInt()
            }

            override fun onFinish() {
                nextExercise()
            }

        }.start()
    }

    override fun onDetach() {
        super.onDetach()
        timer?.cancel()
    }

    companion object {
        @JvmStatic
        fun newInstance()  = MainFragmentExercise()

    }
}