package com.example.kineduexample.data.network.model;

import com.google.gson.annotations.SerializedName;

class RelatedActivities {
    @SerializedName("id")
    private Integer id;

    @SerializedName("name")
    private String name;

    @SerializedName("description")
    private String description;

    @SerializedName("purpose")
    private String purpose;

    @SerializedName("age")
    private Integer age;

    @SerializedName("age_group")
    private String ageGroup;

    @SerializedName("activity_type")
    private String activityType;

    @SerializedName("video_provider_thumbnails")
    private VideoProviderThumbnails videoProviderThumbnails;

    @SerializedName("video_id")
    private String videoId;

    @SerializedName("area_id")
    private Integer areaId;

    @SerializedName("shareable_video_url")
    private String shareableVideoUrl;

    @SerializedName("locked")
    private Boolean locked;

    @SerializedName("picture")
    private String picture;

    @SerializedName("faved")
    private Boolean faved;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPurpose() {
        return purpose;
    }

    public void setPurpose(String purpose) {
        this.purpose = purpose;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getAgeGroup() {
        return ageGroup;
    }

    public void setAgeGroup(String ageGroup) {
        this.ageGroup = ageGroup;
    }

    public String getActivityType() {
        return activityType;
    }

    public void setActivityType(String activityType) {
        this.activityType = activityType;
    }

    public VideoProviderThumbnails getVideoProviderThumbnails() {
        return videoProviderThumbnails;
    }

    public void setVideoProviderThumbnails(VideoProviderThumbnails videoProviderThumbnails) {
        this.videoProviderThumbnails = videoProviderThumbnails;
    }

    public String getVideoId() {
        return videoId;
    }

    public void setVideoId(String videoId) {
        this.videoId = videoId;
    }

    public Integer getAreaId() {
        return areaId;
    }

    public void setAreaId(Integer areaId) {
        this.areaId = areaId;
    }

    public String getShareableVideoUrl() {
        return shareableVideoUrl;
    }

    public void setShareableVideoUrl(String shareableVideoUrl) {
        this.shareableVideoUrl = shareableVideoUrl;
    }

    public Boolean getLocked() {
        return locked;
    }

    public void setLocked(Boolean locked) {
        this.locked = locked;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public Boolean getFaved() {
        return faved;
    }

    public void setFaved(Boolean faved) {
        this.faved = faved;
    }

    @Override
    public String toString() {
        return "RelatedActivities{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", purpose='" + purpose + '\'' +
                ", age=" + age +
                ", ageGroup='" + ageGroup + '\'' +
                ", activityType='" + activityType + '\'' +
                ", videoProviderThumbnails=" + videoProviderThumbnails +
                ", videoId='" + videoId + '\'' +
                ", areaId=" + areaId +
                ", shareableVideoUrl='" + shareableVideoUrl + '\'' +
                ", locked=" + locked +
                ", picture='" + picture + '\'' +
                ", faved=" + faved +
                '}';
    }
}
