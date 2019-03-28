package com.example.kineduexample.ui.article_details;

import android.graphics.Bitmap;

import com.example.kineduexample.data.network.KineduInteractor;
import com.example.kineduexample.data.network.model.ArticleDetail;
import com.example.kineduexample.data.network.model.ArticleDetailsIndex;
import com.example.kineduexample.ui.utils.DownloadImageFromInternet;
import com.example.kineduexample.ui.utils.OnBitmapCreatedListener;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ArticleDetailsPresenter implements OnBitmapCreatedListener {
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

    public void getImagesForArticleDetails(ArticleDetail articleDetail){
        ArrayList<ArticleDetail> articleDetailsList = new ArrayList<>();
        articleDetailsList.add(articleDetail);
        new DownloadImageFromInternet(this, articleDetailsList).execute();
    }


    @Override
    public void onBitmapCreated(List<Bitmap> bitmap) {
        if(view != null)
            view.onLoadBitmaps(bitmap);
    }
}
