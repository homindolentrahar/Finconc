package com.homindolentrahar.finconc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.homindolentrahar.finconc.databinding.ActivityForgotPasswordBinding

class ForgotPasswordActivity : AppCompatActivity() {
    private lateinit var binding: ActivityForgotPasswordBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityForgotPasswordBinding.inflate(layoutInflater)

        setContentView(binding.root)

        binding.btnBack.setOnClickListener {
            finish()
        }

        binding.btnRecover.setOnClickListener {
            val email = binding.editEmail.text.toString()

            Toast.makeText(this, "Email recovery sent to $email", Toast.LENGTH_LONG).show()
        }
    }
}