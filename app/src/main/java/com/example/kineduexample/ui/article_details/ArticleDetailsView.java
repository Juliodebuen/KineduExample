package com.example.kineduexample.ui.article_details;

import android.graphics.Bitmap;
import com.example.kineduexample.data.network.model.ArticleDetail;
import java.util.List;

public interface ArticleDetailsView {
    void onLoadArticleDetails(ArticleDetail articleDetail);
    void onLoadBitmaps(List<Bitmap> bitmap);
}
