package com.example.fitnessapplication

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer

@SuppressLint("CustomSplashScreen")
class SplashActivity : AppCompatActivity() {
    private lateinit var timer : CountDownTimer

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        timer = object : CountDownTimer(2000,1000){
            override fun onTick(p0: Long) {

            }

            override fun onFinish() {

            }

        }
    }
}