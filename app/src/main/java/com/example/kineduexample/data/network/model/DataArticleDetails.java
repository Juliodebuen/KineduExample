package com.example.kineduexample.data.network.model;

import com.google.gson.annotations.SerializedName;

public class DataArticleDetails {
    @SerializedName("article")
    ArticleDetail articleDetail;

    @SerializedName("related_items")
    RelatedItems relatedItems;

    public ArticleDetail getArticleDetail() {
        return articleDetail;
    }

    public void setArticleDetail(ArticleDetail articleDetail) {
        this.articleDetail = articleDetail;
    }

    public RelatedItems getRelatedItems() {
        return relatedItems;
    }

    public void setRelatedItems(RelatedItems relatedItems) {
        this.relatedItems = relatedItems;
    }

    @Override
    public String toString() {
        return "DataArticleDetails{" +
                "articleDetail=" + articleDetail +
                ", relatedItems=" + relatedItems +
                '}';
    }
}
