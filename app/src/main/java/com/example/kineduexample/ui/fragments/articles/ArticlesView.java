package com.example.kineduexample.ui.fragments.articles;

import android.graphics.Bitmap;

import com.example.kineduexample.data.network.model.Articles;

import java.util.List;

public interface ArticlesView {
    void onLoadBitmaps(List<Bitmap> bitmaps);
    void onLoadArticles(List<Articles> articles);
}
