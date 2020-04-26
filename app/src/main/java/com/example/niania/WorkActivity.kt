package com.example.niania

import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import java.util.*
import kotlin.concurrent.schedule

class WorkActivity() : AppCompatActivity() {
    private val detectNoise = DetectNoise()
    private val timer = Timer()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_work)

        val name: String = intent.getStringExtra("name")
        val number: String = intent.getStringExtra("number")
        detectNoise.start()

        val runnable = Runnable {
            fun run()
            {
                val level = detectNoise.getAmplitude()
            }
        }

    }

    override fun onStop() {
        detectNoise.stop()
        super.onStop()
    }
}