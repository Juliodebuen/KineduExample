package com.example.kineduexample.data.network.model

import com.google.gson.annotations.SerializedName

class ArticlesIndex {
    @SerializedName("data")
    var data: DataArticles? = null

    @SerializedName("meta")
    var meta: Meta? = null

    override fun toString(): String {
        return "ArticlesIndex{" +
                "data=" + data +
                ", meta=" + meta +
                '}'.toString()
    }
}
