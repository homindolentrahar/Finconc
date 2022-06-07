package com.homindolentrahar.finconc

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.fragment.app.Fragment
import com.homindolentrahar.finconc.ui.home.HomeFragment
import com.homindolentrahar.finconc.ui.profile.ProfileFragment
import com.homindolentrahar.finconc.ui.settings.SettingsFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        Init views
        val btnHome = findViewById<Button>(R.id.btn_home)
        val btnProfile = findViewById<Button>(R.id.btn_profile)
        val btnSettings = findViewById<Button>(R.id.btn_settings)
        val btnCalculate = findViewById<Button>(R.id.btn_calculate)

        supportFragmentManager.beginTransaction()
            .replace(R.id.frame_layout, HomeFragment())
            .commitNow()

        btnHome.setOnClickListener {
            loadFragment(HomeFragment())
        }
        btnProfile.setOnClickListener {
            loadFragment(ProfileFragment())
        }
        btnSettings.setOnClickListener {
            loadFragment(SettingsFragment())
        }
        btnCalculate.setOnClickListener {
            startActivity(Intent(this, CalculateActivity::class.java))
        }
    }

    private fun loadFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.frame_layout, fragment)
            .commitNow()
    }
}