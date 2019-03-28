package com.example.kineduexample.ui.main;

import android.graphics.Bitmap;

import com.example.kineduexample.data.network.model.DataActivities;

import java.util.List;

public interface MainView {
    void updateUI(DataActivities activities);
}
