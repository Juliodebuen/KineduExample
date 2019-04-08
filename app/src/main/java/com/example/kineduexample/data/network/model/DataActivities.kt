package com.example.kineduexample.data.network.model

import com.google.gson.annotations.SerializedName

class DataActivities {
    @SerializedName("id")
    var id: Int? = null

    @SerializedName("name")
    var name: String? = null

    @SerializedName("type")
    var type: String? = null

    @SerializedName("activities")
    var activities: List<Activities>? = null

    override fun toString(): String {
        return "DataActivities{" +
                "id=" + id +
                ", name='" + name + '\''.toString() +
                ", type='" + type + '\''.toString() +
                ", activities=" + activities +
                '}'.toString()
    }
}
