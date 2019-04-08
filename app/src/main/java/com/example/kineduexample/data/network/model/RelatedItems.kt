package com.example.kineduexample.data.network.model

import com.google.gson.annotations.SerializedName

class RelatedItems {
    @SerializedName("activities")
    var relatedActivities: List<RelatedActivities>? = null

    @SerializedName("articles")
    var relatedArticles: List<RelatedArticles>? = null

    override fun toString(): String {
        return "RelatedItems{" +
                "relatedActivities=" + relatedActivities +
                ", relatedArticles=" + relatedArticles +
                '}'.toString()
    }
}
