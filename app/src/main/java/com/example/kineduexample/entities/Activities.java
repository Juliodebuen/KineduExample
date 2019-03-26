package com.example.kineduexample.entities;

import com.google.gson.annotations.SerializedName;

public class Activities {
    @SerializedName("id")
    private Integer id;

    @SerializedName("name")
    private String name;

    @SerializedName("age")
    private String age;

    @SerializedName("age_group")
    private String ageGroup;

    @SerializedName("activity_type")
    private String activityType;

    @SerializedName("is_holiday")
    private Boolean isHoliday;

    @SerializedName("domain_id")
    private Integer domainId;

    @SerializedName("area_id")
    private Integer areaId;

    @SerializedName("purpose")
    private String purpose;

    @SerializedName("thumbnail")
    private String thumbnail;

    @SerializedName("active_milestones")
    private Integer activeMilestones;

    @SerializedName("completed_milestones")
    private Integer completedMilestones;

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

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
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

    public Boolean getHoliday() {
        return isHoliday;
    }

    public void setHoliday(Boolean holiday) {
        isHoliday = holiday;
    }

    public Integer getDomainId() {
        return domainId;
    }

    public void setDomainId(Integer domainId) {
        this.domainId = domainId;
    }

    public Integer getAreaId() {
        return areaId;
    }

    public void setAreaId(Integer areaId) {
        this.areaId = areaId;
    }

    public String getPurpose() {
        return purpose;
    }

    public void setPurpose(String purpose) {
        this.purpose = purpose;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public Integer getActiveMilestones() {
        return activeMilestones;
    }

    public void setActiveMilestones(Integer activeMilestones) {
        this.activeMilestones = activeMilestones;
    }

    public Integer getCompletedMilestones() {
        return completedMilestones;
    }

    public void setCompletedMilestones(Integer completedMilestones) {
        this.completedMilestones = completedMilestones;
    }

    @Override
    public String toString() {
        return "Activities{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age='" + age + '\'' +
                ", ageGroup='" + ageGroup + '\'' +
                ", activityType='" + activityType + '\'' +
                ", isHoliday=" + isHoliday +
                ", domainId=" + domainId +
                ", areaId=" + areaId +
                ", purpose='" + purpose + '\'' +
                ", thumbnail='" + thumbnail + '\'' +
                ", activeMilestones=" + activeMilestones +
                ", completedMilestones=" + completedMilestones +
                '}';
    }
}
