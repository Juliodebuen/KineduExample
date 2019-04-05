package com.example.kineduexample.ui.article_details;

import com.example.kineduexample.data.network.KineduInteractor;
import com.example.kineduexample.data.network.model.ArticleDetailsIndex;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ArticleDetailsPresenter {
    private KineduInteractor interactor;
    private ArticleDetailsView view;

    public ArticleDetailsPresenter(KineduInteractor interactor){
        this.interactor = interactor;
    }

    public void bind(ArticleDetailsView view){
        this.view = view;
    }

    public void unbind(ArticleDetailsView view){
        view = null;
    }

    public void searchArticleDetails(int articleId){
        interactor.getArticleDetails(articleId)
                .enqueue(new Callback<ArticleDetailsIndex>() {
                    @Override
                    public void onResponse(Call<ArticleDetailsIndex> call, Response<ArticleDetailsIndex> response) {
                        view.onLoadArticleDetails(response.body().getData().getArticleDetail());
                    }

                    @Override
                    public void onFailure(Call<ArticleDetailsIndex> call, Throwable t) {

                    }
                });
    }
}
