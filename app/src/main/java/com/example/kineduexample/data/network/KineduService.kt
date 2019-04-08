package com.example.kineduexample.data.network

import com.example.kineduexample.data.network.model.ActivitiesIndex
import com.example.kineduexample.data.network.model.ArticlesIndex
import com.example.kineduexample.data.network.model.ArticleDetailsIndex
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Path

interface KineduService {
    //Token token=5105f4358e45f6f98057a654c882b7742c3ac5241c81a706acc48c84f8acde9f8a344993ac42369627ae9f2caf1eed42ff1be9562fe2167c9c80908e76e95c49
    @GET("catalogue/activities?skill_id=5&baby_id=6064732")
    fun getActivities(@Header("Authorization") token: String): Call<ActivitiesIndex>

    @GET("catalogue/articles?skill_id=5&baby_id=2064732")
    fun getArticles(@Header("Authorization") token: String): Call<ArticlesIndex>

    @GET("articles/{article_id}")
    fun getArticleDetails(@Header("Authorization") token: String, @Path("article_id") articleId: Int?): Call<ArticleDetailsIndex>
}
