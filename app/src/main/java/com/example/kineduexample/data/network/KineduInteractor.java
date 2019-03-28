package com.example.kineduexample.data.network;

import android.graphics.Bitmap;

import com.example.kineduexample.data.network.model.ActivitiesIndex;
import com.example.kineduexample.data.network.model.ArticleDetail;
import com.example.kineduexample.data.network.model.ArticleDetailsIndex;
import com.example.kineduexample.data.network.model.ArticlesIndex;

import java.util.List;

import retrofit2.Call;

public interface KineduInteractor {
    Call<ActivitiesIndex> getActivities();
    Call<ArticlesIndex> getArticles();
    Call<ArticleDetailsIndex> getArticleDetails(Integer articleId);
}
