package com.example.kineduexample.entities;

import com.google.gson.annotations.SerializedName;

class DataArticles {
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
