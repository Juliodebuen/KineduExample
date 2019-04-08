package com.example.kineduexample.ui.main

import com.example.kineduexample.data.network.KineduInteractor

class MainPresenter(private val interactor: KineduInteractor) {
    private var view: MainView? = null

    fun bind(view: MainView) {
        this.view = view
    }

    fun unbind() {
        view = null
    }


    fun getSelectedSpinnerValue(value: String): Int? {
        try {
            return if (value.contains("0-1 MONTH")) {
                1
            } else Integer.valueOf(value.replace("MONTH", "").replace("S", "").replace("ALL", "").trim { it <= ' ' })
        } catch (e: Exception) {
            e.printStackTrace()
            return -1
        }

    }
}
