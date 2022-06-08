package com.homindolentrahar.finconc.presenter

import com.homindolentrahar.finconc.view.MainView

class MainPresenter(private val view: MainView) {
    fun hitungLuasRect(panjang: Double, lebar: Double) {
        if (panjang == 0.0) {
            view.showError("Panjang tidak boleh kosong")

            return
        }
        if (lebar == 0.0) {
            view.showError("Lebar tidak boleh kosong")

            return
        }

        val luas = panjang * lebar

        view.showResult(luas)
    }

    fun hitungKelilingRect(panjang: Double, lebar: Double) {
        if (panjang == 0.0) {
            view.showError("Panjang tidak boleh kosong")

            return
        }
        if (lebar == 0.0) {
            view.showError("Lebar tidak boleh kosong")

            return
        }

        val keliling = 2 * (panjang + lebar)

        view.showResult(keliling)
    }

    fun hitungLuasSquare(sisi: Double) {
        if (sisi == 0.0) {
            view.showError("Sisi tidak boleh kosong")

            return
        }

        val luas = sisi * sisi

        view.showResult(luas)
    }

    fun hitungKelilingSquare(sisi: Double) {
        if (sisi == 0.0) {
            view.showError("Sisi tidak boleh kosong")

            return
        }

        val keliling = 4 * sisi

        view.showResult(keliling)
    }
}