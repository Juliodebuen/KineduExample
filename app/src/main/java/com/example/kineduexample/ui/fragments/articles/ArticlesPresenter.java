package com.example.kineduexample.ui.fragments.articles;

import com.example.kineduexample.data.network.KineduInteractor;
import com.example.kineduexample.data.network.model.ArticlesIndex;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ArticlesPresenter {
    private KineduInteractor interactor;
    private ArticlesView view;

    public ArticlesPresenter(KineduInteractor interactor){
        this.interactor = interactor;
    }

    public void bind(ArticlesView view){
        this.view = view;
    }

    public void unbind(){
        view = null;
    }

    public void searchArticles(){
        interactor.getArticles()
                .enqueue(new Callback<ArticlesIndex>() {
                    @Override
                    public void onResponse(Call<ArticlesIndex> call, Response<ArticlesIndex> response) {
                        if(view != null)
                            view.onLoadArticles(response.body().getData().getArticles());
                    }

                    @Override
                    public void onFailure(Call<ArticlesIndex> call, Throwable t) {

                    }
                });
    }

}
