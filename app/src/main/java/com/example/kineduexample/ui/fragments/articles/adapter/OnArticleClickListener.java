package com.example.kineduexample.ui.fragments.articles.adapter;

import android.widget.ImageView;
import android.widget.TextView;

public interface OnArticleClickListener {
    void onArticleClick(int articleId, ImageView picture, TextView shorDescription);
}
