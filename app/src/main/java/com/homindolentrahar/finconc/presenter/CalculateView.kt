package com.homindolentrahar.finconc.presenter

interface CalculateView {
    fun updateArea(area: Double)

    fun updateCircumference(circumference: Double)

    fun showError(message: String)

    fun showLoading()
}