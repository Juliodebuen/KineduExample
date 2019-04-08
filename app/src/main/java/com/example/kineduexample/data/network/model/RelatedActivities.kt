package com.example.kineduexample.data.network.model

import com.google.gson.annotations.SerializedName

class RelatedActivities {
    @SerializedName("id")
    var id: Int? = null

    @SerializedName("name")
    var name: String? = null

    @SerializedName("description")
    var description: String? = null

    @SerializedName("purpose")
    var purpose: String? = null

    @SerializedName("age")
    var age: Int? = null

    @SerializedName("age_group")
    var ageGroup: String? = null

    @SerializedName("activity_type")
    var activityType: String? = null

    @SerializedName("video_provider_thumbnails")
    var videoProviderThumbnails: VideoProviderThumbnails? = null

    @SerializedName("video_id")
    var videoId: String? = null

    @SerializedName("area_id")
    var areaId: Int? = null

    @SerializedName("shareable_video_url")
    var shareableVideoUrl: String? = null

    @SerializedName("locked")
    var locked: Boolean? = null

    @SerializedName("picture")
    var picture: String? = null

    @SerializedName("faved")
    var faved: Boolean? = null

    override fun toString(): String {
        return "RelatedActivities{" +
                "id=" + id +
                ", name='" + name + '\''.toString() +
                ", description='" + description + '\''.toString() +
                ", purpose='" + purpose + '\''.toString() +
                ", age=" + age +
                ", ageGroup='" + ageGroup + '\''.toString() +
                ", activityType='" + activityType + '\''.toString() +
                ", videoProviderThumbnails=" + videoProviderThumbnails +
                ", videoId='" + videoId + '\''.toString() +
                ", areaId=" + areaId +
                ", shareableVideoUrl='" + shareableVideoUrl + '\''.toString() +
                ", locked=" + locked +
                ", picture='" + picture + '\''.toString() +
                ", faved=" + faved +
                '}'.toString()
    }
}
