package com.example.kineduexample.data.network.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

class RelatedItems {
    @SerializedName("activities")
    List<RelatedActivities> relatedActivities;

    @SerializedName("articles")
    List<RelatedArticles> relatedArticles;

    public List<RelatedActivities> getRelatedActivities() {
        return relatedActivities;
    }

    public void setRelatedActivities(List<RelatedActivities> relatedActivities) {
        this.relatedActivities = relatedActivities;
    }

    public List<RelatedArticles> getRelatedArticles() {
        return relatedArticles;
    }

    public void setRelatedArticles(List<RelatedArticles> relatedArticles) {
        this.relatedArticles = relatedArticles;
    }

    @Override
    public String toString() {
        return "RelatedItems{" +
                "relatedActivities=" + relatedActivities +
                ", relatedArticles=" + relatedArticles +
                '}';
    }
}
