package com.example.kineduexample.data.network.model

import com.google.gson.annotations.SerializedName

class Meta {
    @SerializedName("page")
    var page: Int? = null

    @SerializedName("per_page")
    var perPage: Int? = null

    @SerializedName("total_pages")
    var totalPages: Int? = null

    @SerializedName("total")
    var total: Int? = null

    override fun toString(): String {
        return "Meta{" +
                "page=" + page +
                ", perPage=" + perPage +
                ", totalPages=" + totalPages +
                ", total=" + total +
                '}'.toString()
    }
}
