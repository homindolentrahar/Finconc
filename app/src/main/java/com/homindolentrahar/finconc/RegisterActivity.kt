package com.homindolentrahar.finconc

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.homindolentrahar.finconc.databinding.ActivityRegisterBinding

class RegisterActivity : AppCompatActivity() {
    private lateinit var binding: ActivityRegisterBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityRegisterBinding.inflate(layoutInflater)

        setContentView(binding.root)

        binding.btnBack.setOnClickListener {
            finish()
        }

        binding.btnRegister.setOnClickListener {
            val fullname = binding.editName.text.toString()
            val email = binding.editEmail.text.toString()
            val password = binding.editPassword.text.toString()

            val bundle = Bundle().apply {
                putString("fullname", fullname)
                putString("email", email)
                putString("password", password)
            }

            Intent(this, HomeActivity::class.java).apply {
                putExtras(bundle)

                startActivity(this)
            }
        }
    }
}