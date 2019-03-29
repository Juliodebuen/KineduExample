package com.example.kineduexample.ui.fragments;

import android.content.Intent;

import com.example.kineduexample.data.network.model.Activities;

import java.util.List;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class MainViewModel extends ViewModel {
    private final MutableLiveData<List<Activities>> activities = new MutableLiveData<>();
    private final MutableLiveData<Boolean> showDialog = new MutableLiveData<>();
    private final MutableLiveData<Integer> ageFilter = new MutableLiveData<>();

    public void setAgeFilter(Integer age){
        this.ageFilter.postValue(age);
    }

    public MutableLiveData<Integer> getAgeFilter(){
        return ageFilter;
    }

    public void setShowDialog(Boolean showDialog){
        this.showDialog.postValue(showDialog);
    }

    public MutableLiveData<Boolean> getShowDialog(){
        return showDialog;
    }

    public void setActivities(List<Activities> activities){
        this.activities.postValue(activities);
    }

    public MutableLiveData<List<Activities>> getActivities(){
        return activities;
    }
}
