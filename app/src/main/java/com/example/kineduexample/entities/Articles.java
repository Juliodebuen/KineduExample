package com.example.kineduexample.entities;

import com.google.gson.annotations.SerializedName;

class Articles {
    @SerializedName("type")
    private String type;

    @SerializedName("id")
    private Integer id;

    @SerializedName("name")
    private String name;

    @SerializedName("min_age")
    private Integer minAge;

    @SerializedName("max_age")
    private Integer maxAge;

    @SerializedName("picture")
    private String picture;

    @SerializedName("area_id")
    private Integer areaId;

    @SerializedName("short_description")
    private String shortDescription;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

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

    public Integer getMinAge() {
        return minAge;
    }

    public void setMinAge(Integer minAge) {
        this.minAge = minAge;
    }

    public Integer getMaxAge() {
        return maxAge;
    }

    public void setMaxAge(Integer maxAge) {
        this.maxAge = maxAge;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
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

    @Override
    public String toString() {
        return "Articles{" +
                "type='" + type + '\'' +
                ", id=" + id +
                ", name='" + name + '\'' +
                ", minAge=" + minAge +
                ", maxAge=" + maxAge +
                ", picture='" + picture + '\'' +
                ", areaId=" + areaId +
                ", shortDescription='" + shortDescription + '\'' +
                '}';
    }
}
