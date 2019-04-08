package com.example.kineduexample.data.network.model

import com.google.gson.annotations.SerializedName

class DataArticles {
    @SerializedName("articles")
    var articles: List<Articles>? = null

    override fun toString(): String {
        return "DataArticles{" +
                "articles=" + articles +
                '}'.toString()
    }
}
