package com.example.counter57

import android.graphics.Color
import com.example.counter57.model.CounterModel
import com.example.counter57.view.CounterView

private const val CONGRATULATION_NUMBER = 10
private const val COLOR_NUMBER = 15

class Presenter {

    var model = CounterModel()
    lateinit var counterView: CounterView


    fun attachView(view: CounterView) {
        this.counterView = view
    }

    fun increment() {
        model.increment()
        isSuccessNumberAchieved()
        setTextColor()
        counterView.showCount(model.number)
    }

    fun decrement() {
        model.decrement()
        isSuccessNumberAchieved()
        setTextColor()
        counterView.showCount(model.number)

    }

    private fun setTextColor() {
        if (model.number == COLOR_NUMBER) {
            counterView.setTextColor(Color.GREEN)
        } else {
            counterView.setTextColor(Color.BLACK)
        }
    }

    private fun isSuccessNumberAchieved() {
        if (model.number == CONGRATULATION_NUMBER) {
            counterView.showToast("Поздравляем")
        }
    }

}