package com.example.kineduexample.ui.main;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;
import androidx.viewpager.widget.ViewPager;
import butterknife.BindView;
import butterknife.ButterKnife;

import android.os.Bundle;
import android.util.Log;

import com.example.kineduexample.R;
import com.example.kineduexample.data.network.KineduInteractor;
import com.example.kineduexample.data.network.KineduInteractorImpl;
import com.example.kineduexample.data.network.model.DataActivities;
import com.example.kineduexample.ui.fragments.MainViewModel;
import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity implements MainView {
    private KineduInteractor interactor;
    private MainPresenter presenter;
    private ViewPagerAdapter viewPagerAdapter;
    private MainViewModel mMainViewModel;


    @BindView(R.id.viewpager)
    ViewPager viewPager;

    @BindView(R.id.tabLayout)
    TabLayout tabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        mMainViewModel = ViewModelProviders.of(this).get(MainViewModel.class);


        interactor = new KineduInteractorImpl();
        presenter = new MainPresenter(interactor);
        presenter.bind(this);

        //presenter.searchActivities();

        //presenter.searchArticleDetails(3004);

        viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager(), this);
        viewPager.setAdapter(viewPagerAdapter);
        tabLayout.setupWithViewPager(viewPager);
    }

    @Override
    public void updateUI(DataActivities dataActivities) {
      /*  mMainViewModel.setActivities(dataActivities.onLoadActivities());

        presenter.getImagesForActivities(dataActivities.onLoadActivities());
        */
        Log.d("Result", dataActivities.toString());
    }

    @Override
    protected void onDestroy() {
        presenter.unbind();
        super.onDestroy();
    }
}
