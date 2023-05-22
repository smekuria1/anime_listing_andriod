
package com.example.newsplus.models;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

@Generated("jsonschema2pojo")
public class Pagination implements Serializable {

    @SerializedName("last_visible_page")
    @Expose
    private Integer lastVisiblePage;
    @SerializedName("has_next_page")
    @Expose
    private Boolean hasNextPage;
    @SerializedName("current_page")
    @Expose
    private Integer currentPage;
    @SerializedName("items")
    @Expose
    private Items items;

    public Integer getLastVisiblePage() {
        return lastVisiblePage;
    }

    public void setLastVisiblePage(Integer lastVisiblePage) {
        this.lastVisiblePage = lastVisiblePage;
    }

    public Pagination withLastVisiblePage(Integer lastVisiblePage) {
        this.lastVisiblePage = lastVisiblePage;
        return this;
    }

    public Boolean getHasNextPage() {
        return hasNextPage;
    }

    public void setHasNextPage(Boolean hasNextPage) {
        this.hasNextPage = hasNextPage;
    }

    public Pagination withHasNextPage(Boolean hasNextPage) {
        this.hasNextPage = hasNextPage;
        return this;
    }

    public Integer getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(Integer currentPage) {
        this.currentPage = currentPage;
    }

    public Pagination withCurrentPage(Integer currentPage) {
        this.currentPage = currentPage;
        return this;
    }

    public Items getItems() {
        return items;
    }

    public void setItems(Items items) {
        this.items = items;
    }

    public Pagination withItems(Items items) {
        this.items = items;
        return this;
    }

}
