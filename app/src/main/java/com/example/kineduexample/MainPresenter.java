package com.example.kineduexample;

import com.example.kineduexample.api.KineduInteractor;
import com.example.kineduexample.entities.ActivitiesIndex;
import com.example.kineduexample.interfaces.MainView;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainPresenter {
    private KineduInteractor interactor;
    private MainView view;

    public MainPresenter(KineduInteractor interactor){
        this.interactor = interactor;
    }

    public void bind(MainView view){
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
                            view.updateUI(response.body().getDataActivities());
                        }
                    }

                    @Override
                    public void onFailure(Call<ActivitiesIndex> call, Throwable t) {
                        t.printStackTrace();
                    }
                });
    }
}
