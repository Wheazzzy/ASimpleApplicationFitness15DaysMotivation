package com.example.fitnessapplication.Adapters

import android.view.View
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.fitnessapplication.R
import com.example.fitnessapplication.databinding.DaysListItemBinding

class DayAdapter: ListAdapter<DayModel, DayAdapter.DayHolder> {

    class DayHolder(view: View): RecyclerView.ViewHolder(view){
        private val binding = DaysListItemBinding.bind(view)
        fun settingData(day: DayModel) = with(binding){
            val name = root.context.getString(R.string.day) + " ${adapterPosition + 1}"
            names.text = name
            val exercisesCounter = day.exercises.split(",").size.toString()
            counters.text = exercisesCounter
        }

    }

}