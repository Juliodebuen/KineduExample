package com.example.kineduexample.ui.main;

import android.content.Context;

import com.example.kineduexample.R;
import com.example.kineduexample.ui.main.fragments.ActivitesFragment;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class ViewPagerAdapter extends FragmentPagerAdapter {
    private int NUM_FRAGMENTS = 2;
    private Context context;

    public ViewPagerAdapter(FragmentManager fm, Context context) {
        super(fm);
        this.context = context;
    }

    @Override
    public Fragment getItem(int position) {
        if(position == 1){
            return ActivitesFragment.newInstance();
        }else{
            return ActivitesFragment.newInstance();
        }
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        if(position == 1){
            return context.getString(R.string.activities);
        }else{
            return context.getString(R.string.acticles);
        }
    }

    @Override
    public int getCount() {
        return NUM_FRAGMENTS;
    }
}
