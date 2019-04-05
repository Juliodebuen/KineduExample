package com.example.kineduexample.ui.fragments.activities;

import com.example.kineduexample.data.network.KineduInteractor;
import com.example.kineduexample.data.network.model.ActivitiesIndex;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ActivitiesPresenter {
    private KineduInteractor interactor;
    private ActivitiesView view;

    public ActivitiesPresenter(KineduInteractor interactor){
        this.interactor = interactor;
    }

    public void bind(ActivitiesView view){
        this.view = view;
    }

    public void unbind(){
        view = null;
    }

    public void searchActivities(){
        interactor.getActivities()
                .enqueue(new Callback<ActivitiesIndex>() {
                    @Override
                    public void onResponse(Call<ActivitiesIndex> call, Response<ActivitiesIndex> response) {
                        if(view != null){
                            view.onLoadActivities(response.body().getDataActivities().getActivities());
                        }
                    }

                    @Override
                    public void onFailure(Call<ActivitiesIndex> call, Throwable t) {
                        t.printStackTrace();
                    }
                });
    }

}
