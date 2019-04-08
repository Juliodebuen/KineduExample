package com.example.kineduexample.data.network.model

import com.google.gson.annotations.SerializedName

class VideoProviderThumbnails {
    @SerializedName("size1")
    var size1: String? = null

    @SerializedName("size2")
    var size2: String? = null

    @SerializedName("size3")
    var size3: String? = null

    @SerializedName("size4")
    var size4: String? = null

    @SerializedName("size5")
    var size5: String? = null

    @SerializedName("size6")
    var size6: String? = null

    override fun toString(): String {
        return "VideoProviderThumbnails{" +
                "size1='" + size1 + '\''.toString() +
                ", size2='" + size2 + '\''.toString() +
                ", size3='" + size3 + '\''.toString() +
                ", size4='" + size4 + '\''.toString() +
                ", size5='" + size5 + '\''.toString() +
                ", size6='" + size6 + '\''.toString() +
                '}'.toString()
    }
}
