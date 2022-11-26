package com.example.fitnessapplication.Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.fitnessapplication.Adapters.DayAdapter
import com.example.fitnessapplication.Adapters.DayModel
import com.example.fitnessapplication.R
import com.example.fitnessapplication.databinding.FragmentMainDaysBinding


class MainFragmentDays: Fragment() {
    private lateinit var binding: FragmentMainDaysBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View {
        binding = FragmentMainDaysBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initializationRecyclerView()
    }

    private fun initializationRecyclerView() = with(binding){
        var adapter = DayAdapter()
        recyclerViewDays.layoutManager = LinearLayoutManager(activity as AppCompatActivity)
        recyclerViewDays.adapter = adapter
        adapter.submitList(fillDaysArray())
    }

    private fun fillDaysArray(): ArrayList<DayModel>{
        val tempArray = ArrayList<DayModel>()
        resources.getStringArray(R.array.exersize_days).forEach {
            tempArray.add(DayModel(it, false))
        }
        return tempArray
    }

    companion object {
        @JvmStatic
        fun newInstance()  = MainFragmentDays()

    }
}