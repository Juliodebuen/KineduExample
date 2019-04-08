package com.example.kineduexample.ui.fragments.articles

import com.example.kineduexample.data.network.model.Articles

interface ArticlesView {
    fun onLoadArticles(articles: List<Articles>)
}
