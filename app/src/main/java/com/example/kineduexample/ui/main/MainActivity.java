package com.example.kineduexample.ui.main;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.viewpager.widget.ViewPager;
import butterknife.BindView;
import butterknife.ButterKnife;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.kineduexample.R;
import com.example.kineduexample.data.network.KineduInteractor;
import com.example.kineduexample.data.network.KineduInteractorImpl;
import com.example.kineduexample.data.network.model.DataActivities;
import com.example.kineduexample.ui.base.BaseActivity;
import com.example.kineduexample.ui.fragments.MainViewModel;
import com.google.android.material.tabs.TabLayout;

public class MainActivity extends BaseActivity implements MainView {
    private KineduInteractor interactor;
    private MainPresenter presenter;
    private ViewPagerAdapter viewPagerAdapter;
    private MainViewModel mMainViewModel;

    @BindView(R.id.viewpager)
    ViewPager viewPager;

    @BindView(R.id.tabLayout)
    TabLayout tabLayout;

    @BindView(R.id.ageSpinner)
    Spinner ageSpinner;

    private AdapterView.OnItemSelectedListener listener = new AdapterView.OnItemSelectedListener() {
        @Override
        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
            ((TextView) parent.getChildAt(0)).setTextColor(Color.WHITE);
            mMainViewModel.setAgeFilter(presenter.getSelectedSpinnerValue(ageSpinner.getSelectedItem().toString()));
        }

        @Override
        public void onNothingSelected(AdapterView<?> parent) {

        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        mMainViewModel = ViewModelProviders.of(this).get(MainViewModel.class);
        setProgressDialog(getString(R.string.loading));

        interactor = new KineduInteractorImpl();
        presenter = new MainPresenter(interactor);
        presenter.bind(this);
        viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager(), this);
        viewPager.setAdapter(viewPagerAdapter);
        tabLayout.setupWithViewPager(viewPager);

        mMainViewModel.getShowDialog().observe(this, new Observer<Boolean>() {
            @Override
            public void onChanged(Boolean aBoolean) {
                if(aBoolean){
                    showProgressDialog();
                }else{
                    hideProgressDialog();
                }
            }
        });


        ageSpinner.setOnItemSelectedListener(listener);
    }



    @Override
    public void updateUI(DataActivities dataActivities) {
        Log.d("Result", dataActivities.toString());
    }

    @Override
    protected void onDestroy() {
        presenter.unbind();
        super.onDestroy();
    }
}
