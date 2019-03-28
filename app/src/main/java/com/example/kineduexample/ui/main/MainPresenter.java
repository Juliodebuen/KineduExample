package com.example.kineduexample.ui.main;

import android.util.Log;

import com.example.kineduexample.data.network.KineduInteractor;
import com.example.kineduexample.data.network.model.ActivitiesIndex;
import com.example.kineduexample.data.network.model.ArticleDetail;
import com.example.kineduexample.data.network.model.ArticlesIndex;

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

    public void searchArticleDetails(int articleId){
        interactor.getArticleDetails(articleId)
                .enqueue(new Callback<ArticleDetail>() {
                    @Override
                    public void onResponse(Call<ArticleDetail> call, Response<ArticleDetail> response) {
                        Log.d("RESPONSE", response.body().toString());
                    }

                    @Override
                    public void onFailure(Call<ArticleDetail> call, Throwable t) {

                    }
                });
    }

}
