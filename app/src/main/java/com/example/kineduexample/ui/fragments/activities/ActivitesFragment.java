package com.example.kineduexample.ui.fragments.activities;

import androidx.lifecycle.ViewModelProviders;

import android.graphics.Bitmap;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.kineduexample.R;
import com.example.kineduexample.data.network.KineduInteractor;
import com.example.kineduexample.data.network.KineduInteractorImpl;
import com.example.kineduexample.data.network.model.Activities;
import com.example.kineduexample.ui.fragments.activities.adapter.ActivitiesAdapter;
import com.example.kineduexample.ui.fragments.MainViewModel;

import java.util.List;

public class ActivitesFragment extends Fragment implements ActivitiesView{
    private KineduInteractor interactor;
    private ActivitiesPresenter presenter;
    private MainViewModel mMainViewModel;
    private List<Activities> activitiesList;

    @BindView(R.id.activitiesRecyclerView)
    RecyclerView mRecyclerView;

    public static ActivitesFragment newInstance() {
        return new ActivitesFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.activites_fragment, container, false);
        ButterKnife.bind(this, rootView);
        mMainViewModel = ViewModelProviders.of(getActivity()).get(MainViewModel.class);

        interactor = new KineduInteractorImpl();
        presenter = new ActivitiesPresenter(interactor);
        presenter.bind(this);

        presenter.searchActivities();

      /*  mMainViewModel.getActivities().observe(this, new Observer<List<Activities>>() {
            @Override
            public void onChanged(List<Activities> activities) {
                if(activities != null && activities.size() > 0){
                    ActivitiesAdapter adapter = new ActivitiesAdapter(activities);
                    LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
                    linearLayoutManager.setOrientation(RecyclerView.VERTICAL);
                    mRecyclerView.setAdapter(adapter);
                    mRecyclerView.setLayoutManager(linearLayoutManager);
                }
            }
        });*/

        return rootView;
    }

    @Override
    public void onDestroy() {
        presenter.unbind();
        super.onDestroy();
    }

    @Override
    public void onLoadBitmaps(List<Bitmap> bitmaps) {
        if(activitiesList != null && activitiesList.size() > 0){
            ActivitiesAdapter adapter = new ActivitiesAdapter(activitiesList, bitmaps);
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
            linearLayoutManager.setOrientation(RecyclerView.VERTICAL);
            mRecyclerView.setAdapter(adapter);
            mRecyclerView.setLayoutManager(linearLayoutManager);
        }
    }

    @Override
    public void onLoadActivities(List<Activities> activities) {
        presenter.getImagesForActivities(activities);
        this.activitiesList = activities;
    }
}