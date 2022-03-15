package com.homindolentrahar.finconc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        val clickMe = findViewById<Button>(R.id.btn_clickme)

        clickMe.setOnClickListener {
            Toast.makeText(this, "You clicked!", Toast.LENGTH_SHORT).show()
        }
    }
}