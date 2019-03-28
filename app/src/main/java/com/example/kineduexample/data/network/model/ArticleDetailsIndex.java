package com.example.kineduexample.data.network.model;

import com.google.gson.annotations.SerializedName;

public class ArticleDetailsIndex {
    @SerializedName("data")
    DataArticleDetails data;

    public DataArticleDetails getData() {
        return data;
    }

    public void setData(DataArticleDetails data) {
        this.data = data;
    }
}
