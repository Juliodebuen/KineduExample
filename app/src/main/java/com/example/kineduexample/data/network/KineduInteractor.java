package com.example.kineduexample.data.network;

import com.example.kineduexample.data.network.model.ActivitiesIndex;
import com.example.kineduexample.data.network.model.ArticlesIndex;

import retrofit2.Call;

public interface KineduInteractor {
    Call<ActivitiesIndex> getActivities();
    Call<ArticlesIndex> getArticles();
    Call<ArticlesIndex> getArticleDetails(Integer articleId);
}
