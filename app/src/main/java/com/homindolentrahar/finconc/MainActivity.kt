package com.homindolentrahar.finconc

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    private val btnHome = findViewById<Button>(R.id.btn_home)
    private val btnProfile = findViewById<Button>(R.id.btn_profile)
    private val btnSettings = findViewById<Button>(R.id.btn_settings)


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnHome.setOnClickListener {
            val intent = Intent(this, HomeActivity::class.java)
            intent.putExtra("username", "Raharu")

            startActivity(intent)
        }
        btnProfile.setOnClickListener {
            val intent = Intent(this, ProfileActivity::class.java)

            startActivity(intent)
        }
        btnSettings.setOnClickListener {
            val intent = Intent(this, SettingsActivity::class.java)

            startActivity(intent)
        }
    }
}