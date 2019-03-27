package com.example.kineduexample.data.network.model;

import com.google.gson.annotations.SerializedName;

class RelatedArticles {
    @SerializedName("id")
    private Integer id;

    @SerializedName("title")
    private String title;

    @SerializedName("picture")
    private String picture;

    @SerializedName("link")
    private String link;

    @SerializedName("area_id")
    private Integer areaId;

    @SerializedName("short_description")
    private String shortDescription;

    @SerializedName("faved")
    private Boolean faved;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public Integer getAreaId() {
        return areaId;
    }

    public void setAreaId(Integer areaId) {
        this.areaId = areaId;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

    public Boolean getFaved() {
        return faved;
    }

    public void setFaved(Boolean faved) {
        this.faved = faved;
    }

    @Override
    public String toString() {
        return "RelatedArticles{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", picture='" + picture + '\'' +
                ", link='" + link + '\'' +
                ", areaId=" + areaId +
                ", shortDescription='" + shortDescription + '\'' +
                ", faved=" + faved +
                '}';
    }
}
