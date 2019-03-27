package com.example.kineduexample.ui.main.fragments;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

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
import com.example.kineduexample.data.network.model.Activities;
import com.example.kineduexample.ui.main.adapter.ActivitiesAdapter;

import java.util.List;

public class ActivitesFragment extends Fragment {

    private MainViewModel mMainViewModel;

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

        mMainViewModel.getActivities().observe(this, new Observer<List<Activities>>() {
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
        });

        return rootView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

}
