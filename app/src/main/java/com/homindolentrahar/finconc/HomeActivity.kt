package com.homindolentrahar.finconc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.homindolentrahar.finconc.databinding.ActivityHomeBinding
import com.homindolentrahar.finconc.fragment.HistoryFragment
import com.homindolentrahar.finconc.fragment.HomeFragment
import com.homindolentrahar.finconc.fragment.PaymentFragment
import com.homindolentrahar.finconc.fragment.SettingFragment

class HomeActivity : AppCompatActivity() {
    private lateinit var binding: ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityHomeBinding.inflate(layoutInflater)

        setContentView(binding.root)

        supportFragmentManager
            .beginTransaction()
            .replace(R.id.frame_layout, HomeFragment())
            .commitNow()

        binding.navbar.setOnItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.menu_home -> {
                    replaceFragment(HomeFragment())
                }
                R.id.menu_history -> {
                    replaceFragment(HistoryFragment())
                }
                R.id.menu_payment -> {
                    replaceFragment(PaymentFragment())
                }
                R.id.menu_setting -> {
                    replaceFragment(SettingFragment())
                }
            }
            true
        }
    }

    private fun replaceFragment(fragment: Fragment) {
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.frame_layout, fragment)
            .commitNow()
    }

}