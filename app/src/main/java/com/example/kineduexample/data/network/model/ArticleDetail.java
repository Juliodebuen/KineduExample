package com.example.kineduexample.data.network.model;

import com.google.gson.annotations.SerializedName;

public class ArticleDetail {
    @SerializedName("data")
    DataArticleDetails data;

    @SerializedName("related_items")
    RelatedItems relatedItems;

    public DataArticleDetails getData() {
        return data;
    }

    public void setData(DataArticleDetails data) {
        this.data = data;
    }

    public RelatedItems getRelatedItems() {
        return relatedItems;
    }

    public void setRelatedItems(RelatedItems relatedItems) {
        this.relatedItems = relatedItems;
    }

    @Override
    public String toString() {
        return "ArticleDetail{" +
                "data=" + data +
                ", relatedItems=" + relatedItems +
                '}';
    }
}
