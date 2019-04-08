package com.example.kineduexample.data.network

import com.example.kineduexample.data.network.model.ActivitiesIndex
import com.example.kineduexample.data.network.model.ArticleDetailsIndex
import com.example.kineduexample.data.network.model.ArticlesIndex
import retrofit2.Call

interface KineduInteractor {
    fun getActivities(): Call<ActivitiesIndex>
    fun getArticles(): Call<ArticlesIndex>
    fun getArticleDetails(articleId: Int?): Call<ArticleDetailsIndex>
}
