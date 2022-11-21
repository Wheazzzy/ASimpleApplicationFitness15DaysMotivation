package com.example.fitnessapplication.Adapters

import android.view.View
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.fitnessapplication.databinding.DaysListItemBinding

class DayAdapter: ListAdapter<DayModel, > {

    class DayHolder(view: View): RecyclerView.ViewHolder(view){
        private val binding = DaysListItemBinding.bind(view)
        fun settingData(day: DayModel) = with(binding){
            names.text
        }

    }

}