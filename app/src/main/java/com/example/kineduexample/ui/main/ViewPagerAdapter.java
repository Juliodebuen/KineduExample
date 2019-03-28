package com.example.kineduexample.ui.main;

import android.content.Context;

import com.example.kineduexample.R;
import com.example.kineduexample.ui.fragments.activities.ActivitesFragment;
import com.example.kineduexample.ui.fragments.articles.ArticlesFragment;

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
        if(position == 0){
            return ActivitesFragment.newInstance();
        }else{
            return ArticlesFragment.newInstance();
        }
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        if(position == 0){
            return context.getString(R.string.activities);
        }else{
            return context.getString(R.string.articles);
        }
    }

    @Override
    public int getCount() {
        return NUM_FRAGMENTS;
    }
}
