package com.homindolentrahar.finconc.view

interface MainView {
    fun showResult(result: Double)
    fun showError(error: String)
    fun showLoading()
}