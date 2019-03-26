package com.example.kineduexample.data.network.model;

import com.google.gson.annotations.SerializedName;

public class ActivitiesIndex {
    @SerializedName("data")
    DataActivities dataActivities;

    @SerializedName("meta")
    Meta meta;

    public DataActivities getDataActivities() {
        return dataActivities;
    }

    public void setDataActivities(DataActivities dataActivities) {
        this.dataActivities = dataActivities;
    }

    public Meta getMeta() {
        return meta;
    }

    public void setMeta(Meta meta) {
        this.meta = meta;
    }

    @Override
    public String toString() {
        return "ActivitiesIndex{" +
                "dataActivities=" + dataActivities +
                ", meta=" + meta +
                '}';
    }
}
