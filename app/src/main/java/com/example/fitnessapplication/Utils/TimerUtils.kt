package com.example.fitnessapplication.Utils

import android.annotation.SuppressLint
import java.text.SimpleDateFormat
import java.util.*


@SuppressLint("SimpleDateFormat")
object TimerUtils {
    private val formatter = SimpleDateFormat("mm.ss")

    fun getTime(time: Long): String{
        val calendarView = Calendar.getInstance()
        calendarView.timeInMillis = time
        return formatter.format(calendarView.time)
    }
}