package com.example.fitnessapplication.Adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.fitnessapplication.R
import com.example.fitnessapplication.databinding.DaysListItemBinding

class ExerciseAdapter(var listener: Listener): ListAdapter<DayModel, ExerciseAdapter.DayHolder>(MyComparator()) {

    class DayHolder(view: View): RecyclerView.ViewHolder(view){
        private val binding = DaysListItemBinding.bind(view)
        fun settingData(day: DayModel,  listener: Listener) = with(binding){
            val name = root.context.getString(R.string.day) + " ${adapterPosition + 1}"
            names.text = name
            val exercisesCounter = day.exercises.split(",").size.toString() + " " + root.context.getString(R.string.exercises)
            counters.text = exercisesCounter
            itemView.setOnClickListener{
                listener.onClick(day)
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DayHolder {
        val view = LayoutInflater.from(parent. context).inflate(R.layout.days_list_item, parent, false)
        return DayHolder(view)
    }

    override fun onBindViewHolder(holder: DayHolder, position: Int) {
        holder.settingData(getItem(position), listener)
    }

    class MyComparator: DiffUtil.ItemCallback<DayModel>(){

        override fun areItemsTheSame(oldItem: DayModel, newItem: DayModel): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: DayModel, newItem: DayModel): Boolean {
            return oldItem == newItem
        }

    }

    interface Listener{
        fun onClick(days: DayModel)

    }

}