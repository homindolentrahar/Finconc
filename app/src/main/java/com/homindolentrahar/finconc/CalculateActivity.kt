package com.homindolentrahar.finconc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.homindolentrahar.finconc.databinding.ActivityCalculateBinding
import com.homindolentrahar.finconc.presenter.CalculatePresenter
import com.homindolentrahar.finconc.presenter.CalculateView

enum class CalculateType {
    luas, keliling
}

class CalculateActivity : AppCompatActivity(), CalculateView {
    private lateinit var binding: ActivityCalculateBinding
    private lateinit var presenter: CalculatePresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityCalculateBinding.inflate(layoutInflater)

        setContentView(binding.root)
        presenter = CalculatePresenter(this)

        binding.btnLuas.setOnClickListener {
            calculate(CalculateType.luas)
        }

        binding.btnKeliling.setOnClickListener {
            calculate(CalculateType.keliling)
        }
    }

    private fun calculate(type: CalculateType) {
        val panjang = binding.editPanjang.text.toString().toDouble()
        val lebar = binding.editLebar.text.toString().toDouble()

        when (type) {
            CalculateType.luas -> {
                presenter.calculateRectArea(panjang, lebar)
            }
            CalculateType.keliling -> {
                presenter.calculateRectCircumference(panjang, lebar)
            }
        }
    }

    override fun updateArea(area: Double) {
        binding.tvResult.text = area.toString()
    }

    override fun updateCircumference(circumference: Double) {
        binding.tvResult.text = circumference.toString()
    }

    override fun showError(message: String) {
        binding.tvError.text = message
    }

    override fun showLoading() {

    }


}