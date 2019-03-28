package com.example.kineduexample.data.network;

import com.example.kineduexample.data.network.model.ActivitiesIndex;
import com.example.kineduexample.data.network.model.ArticleDetail;
import com.example.kineduexample.data.network.model.ArticleDetailsIndex;
import com.example.kineduexample.data.network.model.ArticlesIndex;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class KineduInteractorImpl implements KineduInteractor{
    private String token = "Token token=5105f4358e45f6f98057a654c882b7742c3ac5241c81a706acc48c84f8acde9f8a344993ac42369627ae9f2caf1eed42ff1be9562fe2167c9c80908e76e95c49";
    private KineduService service;

    public KineduInteractorImpl(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://staging.kinedu.com/api/v3/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        service = retrofit.create(KineduService.class);
    }


    @Override
    public Call<ActivitiesIndex> getActivities() {
        return service.getActivities(token);
    }

    @Override
    public Call<ArticlesIndex> getArticles() {
        return service.getArticles(token);
    }

    @Override
    public Call<ArticleDetailsIndex> getArticleDetails(Integer articleId) {
        return service.getArticleDetails(token, articleId);
    }
}
