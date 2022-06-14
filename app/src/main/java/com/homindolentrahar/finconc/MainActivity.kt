package com.homindolentrahar.finconc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.homindolentrahar.finconc.databinding.ActivityMainBinding

enum class OperatorType {
    tambah, kurang, kali, bagi
}

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)

        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        binding.btnTambah.setOnClickListener {
            calculate(OperatorType.tambah)
        }
        binding.btnKurang.setOnClickListener {
            calculate(OperatorType.kurang)
        }
        binding.btnKali.setOnClickListener {
            calculate(OperatorType.kali)
        }
        binding.btnBagi.setOnClickListener {
            calculate(OperatorType.bagi)
        }

        viewModel.result.observe(this) { result ->
            binding.tvResult.text = result.toString()

            binding.editOperandOne.text.clear()
            binding.editOperandTwo.text.clear()
        }
    }

    private fun calculate(type: OperatorType) {
        val operandOne = binding.editOperandOne.text.toString().toFloat()
        val operandTwo = binding.editOperandTwo.text.toString().toFloat()

        when (type) {
            OperatorType.tambah -> {
                viewModel.tambah(operandOne, operandTwo)
            }
            OperatorType.kurang -> {
                viewModel.kurang(operandOne, operandTwo)
            }
            OperatorType.kali -> {
                viewModel.kali(operandOne, operandTwo)
            }
            OperatorType.bagi -> {
                viewModel.bagi(operandOne, operandTwo)
            }
        }
    }
}