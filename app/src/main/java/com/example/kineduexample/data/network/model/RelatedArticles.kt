package com.example.kineduexample.data.network.model

import com.google.gson.annotations.SerializedName

class RelatedArticles {
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

    @SerializedName("short_description")
    var shortDescription: String? = null

    @SerializedName("faved")
    var faved: Boolean? = null

    override fun toString(): String {
        return "RelatedArticles{" +
                "id=" + id +
                ", title='" + title + '\''.toString() +
                ", picture='" + picture + '\''.toString() +
                ", link='" + link + '\''.toString() +
                ", areaId=" + areaId +
                ", shortDescription='" + shortDescription + '\''.toString() +
                ", faved=" + faved +
                '}'.toString()
    }
}
