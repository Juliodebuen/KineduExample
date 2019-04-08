package com.example.kineduexample.data.network.model

import com.google.gson.annotations.SerializedName

class Articles {
    @SerializedName("type")
    var type: String? = null

    @SerializedName("id")
    var id: Int? = null

    @SerializedName("name")
    var name: String? = null

    @SerializedName("min_age")
    var minAge: Int? = null

    @SerializedName("max_age")
    var maxAge: Int? = null

    @SerializedName("picture")
    var picture: String? = null

    @SerializedName("area_id")
    var areaId: Int? = null

    @SerializedName("short_description")
    var shortDescription: String? = null

    override fun toString(): String {
        return "Articles{" +
                "type='" + type + '\''.toString() +
                ", id=" + id +
                ", name='" + name + '\''.toString() +
                ", minAge=" + minAge +
                ", maxAge=" + maxAge +
                ", picture='" + picture + '\''.toString() +
                ", areaId=" + areaId +
                ", shortDescription='" + shortDescription + '\''.toString() +
                '}'.toString()
    }
}
