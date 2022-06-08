package com.homindolentrahar.finconc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import com.homindolentrahar.finconc.databinding.ActivityMainBinding
import com.homindolentrahar.finconc.presenter.MainPresenter
import com.homindolentrahar.finconc.view.MainView

enum class HitungType {
    luas, keliling
}

class MainActivity : AppCompatActivity(), MainView {
    private lateinit var binding: ActivityMainBinding
    private lateinit var presenter: MainPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        presenter = MainPresenter(this)

        setContentView(binding.root)

        binding.rgShape.setOnCheckedChangeListener { group, checkedId ->
            when (checkedId) {
                R.id.rb_rect -> {
                    binding.formRect.visibility = View.VISIBLE
                    binding.formSquare.visibility = View.GONE
                }
                R.id.rb_square -> {
                    binding.formRect.visibility = View.GONE
                    binding.formSquare.visibility = View.VISIBLE
                }
            }
        }

        binding.btnLuas.setOnClickListener {
            calculate(HitungType.luas)
        }

        binding.btnKeliling.setOnClickListener {
            calculate(HitungType.keliling)
        }
    }

    private fun calculate(type: HitungType) {
        val shape = binding.rgShape.checkedRadioButtonId

        when (shape) {
            R.id.rb_rect -> {
                val panjang = binding.editPanjang.text.toString().toDouble()
                val lebar = binding.editLebar.text.toString().toDouble()

                when (type) {
                    HitungType.luas -> {
                        presenter.hitungLuasRect(panjang, lebar)
                    }
                    HitungType.keliling -> {
                        presenter.hitungKelilingRect(panjang, lebar)
                    }
                }
            }
            R.id.rb_square -> {
                val sisi = binding.editSisi.text.toString().toDouble()

                when (type) {
                    HitungType.luas -> {
                        presenter.hitungLuasSquare(sisi)
                    }
                    HitungType.keliling -> {
                        presenter.hitungKelilingSquare(sisi)
                    }
                }
            }
        }
    }

    override fun showResult(result: Double) {
        binding.tvResult.text = result.toString()
        binding.tvError.text = ""
    }

    override fun showError(error: String) {
        binding.tvResult.text = "..."
        binding.tvError.text = error
    }

    override fun showLoading() {
        binding.tvResult.text = "..."
        binding.tvError.text = ""
    }
}