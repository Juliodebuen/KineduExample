package com.example.kineduexample.data.network.model

import com.google.gson.annotations.SerializedName

class Activities {
    @SerializedName("id")
    var id: Int? = null

    @SerializedName("name")
    var name: String? = null

    @SerializedName("age")
    var age: Int? = null

    @SerializedName("age_group")
    var ageGroup: String? = null

    @SerializedName("activity_type")
    var activityType: String? = null

    @SerializedName("is_holiday")
    var holiday: Boolean? = null

    @SerializedName("domain_id")
    var domainId: Int? = null

    @SerializedName("area_id")
    var areaId: Int? = null

    @SerializedName("purpose")
    var purpose: String? = null

    @SerializedName("thumbnail")
    var thumbnail: String? = null

    @SerializedName("active_milestones")
    var activeMilestones: Int? = null

    @SerializedName("completed_milestones")
    var completedMilestones: Int? = null

    override fun toString(): String {
        return "Activities{" +
                "id=" + id +
                ", name='" + name + '\''.toString() +
                ", age='" + age + '\''.toString() +
                ", ageGroup='" + ageGroup + '\''.toString() +
                ", activityType='" + activityType + '\''.toString() +
                ", isHoliday=" + holiday +
                ", domainId=" + domainId +
                ", areaId=" + areaId +
                ", purpose='" + purpose + '\''.toString() +
                ", thumbnail='" + thumbnail + '\''.toString() +
                ", activeMilestones=" + activeMilestones +
                ", completedMilestones=" + completedMilestones +
                '}'.toString()
    }
}
