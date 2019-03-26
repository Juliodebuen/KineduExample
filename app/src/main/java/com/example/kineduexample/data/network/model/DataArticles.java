package com.example.kineduexample.data.network.model;

import com.google.gson.annotations.SerializedName;

public class DataArticles {
    @SerializedName("articles")
    Articles articles;

    public Articles getArticles() {
        return articles;
    }

    public void setArticles(Articles articles) {
        this.articles = articles;
    }

    @Override
    public String toString() {
        return "DataArticles{" +
                "articles=" + articles +
                '}';
    }
}
