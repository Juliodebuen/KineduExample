package com.example.kineduexample.data.network.model;

import com.google.gson.annotations.SerializedName;

class VideoProviderThumbnails {
    @SerializedName("size1")
    private String size1;

    @SerializedName("size2")
    private String size2;

    @SerializedName("size3")
    private String size3;

    @SerializedName("size4")
    private String size4;

    @SerializedName("size5")
    private String size5;

    @SerializedName("size6")
    private String size6;

    public String getSize1() {
        return size1;
    }

    public void setSize1(String size1) {
        this.size1 = size1;
    }

    public String getSize2() {
        return size2;
    }

    public void setSize2(String size2) {
        this.size2 = size2;
    }

    public String getSize3() {
        return size3;
    }

    public void setSize3(String size3) {
        this.size3 = size3;
    }

    public String getSize4() {
        return size4;
    }

    public void setSize4(String size4) {
        this.size4 = size4;
    }

    public String getSize5() {
        return size5;
    }

    public void setSize5(String size5) {
        this.size5 = size5;
    }

    public String getSize6() {
        return size6;
    }

    public void setSize6(String size6) {
        this.size6 = size6;
    }

    @Override
    public String toString() {
        return "VideoProviderThumbnails{" +
                "size1='" + size1 + '\'' +
                ", size2='" + size2 + '\'' +
                ", size3='" + size3 + '\'' +
                ", size4='" + size4 + '\'' +
                ", size5='" + size5 + '\'' +
                ", size6='" + size6 + '\'' +
                '}';
    }
}
