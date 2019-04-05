package com.example.kineduexample.ui.fragments.articles;

import com.example.kineduexample.data.network.model.Articles;

import java.util.List;

public interface ArticlesView {
    void onLoadArticles(List<Articles> articles);
}
