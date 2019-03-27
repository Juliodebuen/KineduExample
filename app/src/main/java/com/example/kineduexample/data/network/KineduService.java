package com.example.kineduexample.data.network;

import com.example.kineduexample.data.network.model.ActivitiesIndex;
import com.example.kineduexample.data.network.model.ArticleDetail;
import com.example.kineduexample.data.network.model.ArticlesIndex;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Path;

public interface KineduService {
//Token token=5105f4358e45f6f98057a654c882b7742c3ac5241c81a706acc48c84f8acde9f8a344993ac42369627ae9f2caf1eed42ff1be9562fe2167c9c80908e76e95c49
    @GET("catalogue/activities?skill_id=5&baby_id=6064732")
    Call<ActivitiesIndex> getActivities(@Header("Authorization") String token);

    @GET("catalogue/articles?skill_id=5&baby_id=2064732")
    Call<ArticlesIndex> getArticles(@Header("Authorization") String token);

    @GET("articles/{article_id}")
    Call<ArticleDetail> getArticleDetails(@Header("Authorization") String token, @Path("article_id") Integer articleId);
}
