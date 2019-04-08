package com.example.kineduexample.data.network

import com.example.kineduexample.data.network.model.ActivitiesIndex
import com.example.kineduexample.data.network.model.ArticleDetailsIndex
import com.example.kineduexample.data.network.model.ArticlesIndex
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class KineduInteractorImpl : KineduInteractor {
    private val token = "Token token=5105f4358e45f6f98057a654c882b7742c3ac5241c81a706acc48c84f8acde9f8a344993ac42369627ae9f2caf1eed42ff1be9562fe2167c9c80908e76e95c49"
    private val service: KineduService

    init {
        val retrofit = Retrofit.Builder()
                .baseUrl("http://staging.kinedu.com/api/v3/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()

        service = retrofit.create(KineduService::class.java)
    }


    override fun getActivities(): Call<ActivitiesIndex> {
        return service.getActivities(token)
    }

    override fun getArticles(): Call<ArticlesIndex> {
        return service.getArticles(token)
    }

    override fun getArticleDetails(articleId: Int?): Call<ArticleDetailsIndex> {
        return service.getArticleDetails(token, articleId)
    }
}
