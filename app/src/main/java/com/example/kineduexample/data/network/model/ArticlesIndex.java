package com.example.kineduexample.data.network.model;

import com.google.gson.annotations.SerializedName;

public class ArticlesIndex {
    @SerializedName("data")
    private DataArticles data;

    @SerializedName("meta")
    Meta meta;

    public DataArticles getData() {
        return data;
    }

    public void setData(DataArticles data) {
        this.data = data;
    }

    public Meta getMeta() {
        return meta;
    }

    public void setMeta(Meta meta) {
        this.meta = meta;
    }

    @Override
    public String toString() {
        return "ArticlesIndex{" +
                "data=" + data +
                ", meta=" + meta +
                '}';
    }
}
