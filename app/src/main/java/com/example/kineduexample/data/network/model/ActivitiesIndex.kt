package com.example.kineduexample.data.network.model

import com.google.gson.annotations.SerializedName

class ActivitiesIndex {
    @SerializedName("data")
    var dataActivities: DataActivities? = null

    @SerializedName("meta")
    var meta: Meta? = null

    override fun toString(): String {
        return "ActivitiesIndex{" +
                "dataActivities=" + dataActivities +
                ", meta=" + meta +
                '}'.toString()
    }
}
