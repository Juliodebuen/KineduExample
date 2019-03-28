package com.example.kineduexample.ui.fragments.activities;

import android.graphics.Bitmap;

import com.example.kineduexample.data.network.model.Activities;

import java.util.List;

public interface ActivitiesView {
    void onLoadBitmaps(List<Bitmap> bitmaps);
    void onLoadActivities(List<Activities> activities);

}
