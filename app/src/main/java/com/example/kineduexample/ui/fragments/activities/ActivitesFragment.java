package com.example.kineduexample.ui.fragments.activities;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.graphics.Bitmap;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
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
    private Unbinder unbinder;
    private ActivitiesAdapter adapter;

    @BindView(R.id.activitiesRecyclerView)
    RecyclerView mRecyclerView;

    @BindView(R.id.swipeRefresh)
    SwipeRefreshLayout swipeRefresh;

    public static ActivitesFragment newInstance() {
        return new ActivitesFragment();
    }

    @Override
    public View onCreateView(@NonNull final LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.activites_fragment, container, false);
        unbinder = ButterKnife.bind(this, rootView);
        mMainViewModel = ViewModelProviders.of(getActivity()).get(MainViewModel.class);

        interactor = new KineduInteractorImpl();
        presenter = new ActivitiesPresenter(interactor);
        presenter.bind(this);

        presenter.searchActivities();
        mMainViewModel.setShowDialog(true);

        swipeRefresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                presenter.searchActivities();
            }
        });

        mMainViewModel.getAgeFilter().observe(this, new Observer<Integer>() {
            @Override
            public void onChanged(Integer integer) {
                if(adapter != null) {
                    adapter.getFilter().filter(String.valueOf(integer));
                }
            }
        });

        return rootView;
    }

    @Override
    public void onDestroy() {
        presenter.unbind();
        unbinder.unbind();
        super.onDestroy();
    }

    @Override
    public void onLoadBitmaps(List<Bitmap> bitmaps) {
        if(activitiesList != null && activitiesList.size() > 0){
            adapter = new ActivitiesAdapter(activitiesList, bitmaps);
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
            linearLayoutManager.setOrientation(RecyclerView.VERTICAL);
            mRecyclerView.setAdapter(adapter);
            mRecyclerView.setLayoutManager(linearLayoutManager);
            mRecyclerView.getViewTreeObserver()
                    .addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
                        @Override
                        public void onGlobalLayout() {
                            mMainViewModel.setShowDialog(false);
                            mRecyclerView.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                        }
                    });
            swipeRefresh.setRefreshing(false);
        }
    }

    @Override
    public void onLoadActivities(List<Activities> activities) {
        presenter.getImagesForActivities(activities);
        this.activitiesList = activities;
    }
}
