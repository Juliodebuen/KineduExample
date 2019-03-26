package com.example.kineduexample.data.network.model;

import com.google.gson.annotations.SerializedName;

public class Meta {
    @SerializedName("page")
    private Integer page;

    @SerializedName("per_page")
    private Integer perPage;

    @SerializedName("total_pages")
    private Integer totalPages;

    @SerializedName("total")
    private Integer total;

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getPerPage() {
        return perPage;
    }

    public void setPerPage(Integer perPage) {
        this.perPage = perPage;
    }

    public Integer getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(Integer totalPages) {
        this.totalPages = totalPages;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return "Meta{" +
                "page=" + page +
                ", perPage=" + perPage +
                ", totalPages=" + totalPages +
                ", total=" + total +
                '}';
    }
}
