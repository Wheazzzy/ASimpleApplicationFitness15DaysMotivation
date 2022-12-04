package com.example.fitnessapplication.Utils

import java.util.concurrent.Flow

interface ConnectivityObserver {

    fun observe(): Flow<Status>

    enum class Status{
        Available, Unavailable, Losing, Lost
    }
}