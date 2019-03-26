package com.example.kineduexample.api;

import com.example.kineduexample.entities.ActivitiesIndex;
import com.example.kineduexample.entities.ArticlesIndex;

import retrofit2.Call;

public interface KineduInteractor {
    Call<ActivitiesIndex> getActivities();
    Call<ArticlesIndex> getArticles();
    Call<ArticlesIndex> getArticleDetails(Integer articleId);
}
