package com.homindolentrahar.finconc

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.homindolentrahar.finconc.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityLoginBinding.inflate(layoutInflater)

        setContentView(binding.root)

        binding.btnTextForgotPassword.setOnClickListener {
            Intent(this, ForgotPasswordActivity::class.java).apply {
                startActivity(this)
            }
        }

        binding.btnLogin.setOnClickListener {
            val email = binding.editEmail.text.toString()
            val password = binding.editPassword.text.toString()

            val bundle = Bundle().apply {
                putString("email", email)
                putString("password", password)
            }

            Intent(this, HomeActivity::class.java).apply {
                putExtras(bundle)

                startActivity(this)
            }
        }

        binding.btnTextRegister.setOnClickListener {
            Intent(this, RegisterActivity::class.java).apply {
                startActivity(this)
            }
        }

    }
}