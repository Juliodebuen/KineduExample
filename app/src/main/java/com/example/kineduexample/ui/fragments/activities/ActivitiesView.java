package com.example.kineduexample.ui.fragments.activities;

import com.example.kineduexample.data.network.model.Activities;
import java.util.List;

public interface ActivitiesView {
    void onLoadActivities(List<Activities> activities);

}
