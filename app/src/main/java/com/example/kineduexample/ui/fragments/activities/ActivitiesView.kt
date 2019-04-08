package com.example.kineduexample.ui.fragments.activities

import com.example.kineduexample.data.network.model.Activities

interface ActivitiesView {
    fun onLoadActivities(activities: List<Activities>)
}
