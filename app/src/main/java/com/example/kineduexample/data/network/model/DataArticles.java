package com.example.kineduexample.data.network.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class DataArticles {
    @SerializedName("articles")
    List<Articles> articles;

    public List<Articles> getArticles() {
        return articles;
    }

    public void setArticles(List<Articles> articles) {
        this.articles = articles;
    }

    @Override
    public String toString() {
        return "DataArticles{" +
                "articles=" + articles +
                '}';
    }
}
