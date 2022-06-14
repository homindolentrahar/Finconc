package com.homindolentrahar.finconc

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {
    private val _result = MutableLiveData<Float>()
    val result: LiveData<Float>
        get() = _result

    fun tambah(operandOne: Float, operandTwo: Float) {
        _result.value = operandOne + operandTwo
    }

    fun kurang(operandOne: Float, operandTwo: Float) {
        _result.value = operandOne - operandTwo
    }

    fun kali(operandOne: Float, operandTwo: Float) {
        _result.value = operandOne * operandTwo
    }

    fun bagi(operandOne: Float, operandTwo: Float) {
        _result.value = operandOne / operandTwo
    }
}