package com.example.kineduexample.ui.fragments.articles;

import android.graphics.Bitmap;

import com.example.kineduexample.data.network.KineduInteractor;
import com.example.kineduexample.data.network.model.Articles;
import com.example.kineduexample.data.network.model.ArticlesIndex;
import com.example.kineduexample.ui.utils.DownloadImageFromInternet;
import com.example.kineduexample.ui.utils.OnBitmapCreatedListener;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ArticlesPresenter implements OnBitmapCreatedListener {
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

    public void getImagesForArticles(List<Articles> articlesList){
        new DownloadImageFromInternet(this, articlesList).execute();
    }

    @Override
    public void onBitmapCreated(List<Bitmap> bitmap) {
        if(view != null)
            view.onLoadBitmaps(bitmap);
    }
}
