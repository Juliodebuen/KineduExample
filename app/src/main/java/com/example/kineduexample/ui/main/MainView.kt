package com.example.kineduexample.ui.main

import com.example.kineduexample.data.network.model.DataActivities

interface MainView {
    fun updateUI(activities: DataActivities)
}
