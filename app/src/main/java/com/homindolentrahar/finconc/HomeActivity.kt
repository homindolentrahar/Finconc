package com.homindolentrahar.finconc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class HomeActivity : AppCompatActivity() {
    private val btnBack = findViewById<Button>(R.id.btn_back)
    private val txtHome = findViewById<TextView>(R.id.txt_home)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        intent.getStringExtra("username")?.let { username ->
            txtHome.text = "Hello ${username}, this is HomeActivity"
        }
        btnBack.setOnClickListener {
            finish()
        }
    }
}