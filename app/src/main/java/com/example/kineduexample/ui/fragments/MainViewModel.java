package com.example.kineduexample.ui.fragments;

import com.example.kineduexample.data.network.model.Activities;

import java.util.List;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class MainViewModel extends ViewModel {
    private final MutableLiveData<List<Activities>> activities = new MutableLiveData<>();

    public void setActivities(List<Activities> activities){
        this.activities.postValue(activities);
    }

    public MutableLiveData<List<Activities>> getActivities(){
        return activities;
    }
}
