package com.example.kineduexample.data.network.model

import com.google.gson.annotations.SerializedName

class DataArticleDetails {
    @SerializedName("article")
    var articleDetail: ArticleDetail? = null

    @SerializedName("related_items")
    var relatedItems: RelatedItems? = null

    override fun toString(): String {
        return "DataArticleDetails{" +
                "articleDetail=" + articleDetail +
                ", relatedItems=" + relatedItems +
                '}'.toString()
    }
}
