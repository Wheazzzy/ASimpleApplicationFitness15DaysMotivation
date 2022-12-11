package com.example.fitnessapplication

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class LogInActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_log_in)

        val registerText: TextView = findViewById(R.id.textView_registerNow)
        registerText.setOnClickListener{
            val intent = Intent(this, RegistrationActivty::class.java)
            startActivity(intent)
        }
    }
}