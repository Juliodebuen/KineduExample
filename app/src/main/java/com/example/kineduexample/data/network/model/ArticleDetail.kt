package com.example.kineduexample.data.network.model

import com.google.gson.annotations.SerializedName

class ArticleDetail {
    @SerializedName("id")
    var id: Int? = null

    @SerializedName("title")
    var title: String? = null

    @SerializedName("picture")
    var picture: String? = null

    @SerializedName("link")
    var link: String? = null

    @SerializedName("area_id")
    var areaId: Int? = null

    @SerializedName("body")
    var body: String? = null

    @SerializedName("faved")
    var faved: Boolean? = null

    override fun toString(): String {
        return "ArticleDetail{" +
                "id=" + id +
                ", title='" + title + '\''.toString() +
                ", picture='" + picture + '\''.toString() +
                ", link='" + link + '\''.toString() +
                ", areaId=" + areaId +
                ", body='" + body + '\''.toString() +
                ", faved=" + faved +
                '}'.toString()
    }
}
