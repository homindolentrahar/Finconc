package com.homindolentrahar.finconc.presenter

class CalculatePresenter(
    private val view: CalculateView
) {
    fun calculateRectArea(panjang: Double, lebar: Double) {
        if (panjang < 0) {
            view.showError("Insufficient panjang!")

            return
        } else if (lebar < 0) {
            view.showError("Insufficient lebar!")

            return
        }

        view.showLoading()

        val area = panjang * lebar

        view.updateArea(area)
    }

    fun calculateRectCircumference(panjang: Double, lebar: Double) {
        if (panjang < 0) {
            view.showError("Insufficient panjang!")

            return
        } else if (lebar < 0) {
            view.showError("Insufficient lebar!")

            return
        }

        view.showLoading()

        val circumference = 2 * (panjang + lebar)

        view.updateCircumference(circumference)
    }
}