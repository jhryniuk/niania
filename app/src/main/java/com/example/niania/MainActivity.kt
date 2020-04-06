package com.example.niania

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        welcomeButton.setOnClickListener {
            val intent = Intent(this@MainActivity, ChoiceContactActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}
