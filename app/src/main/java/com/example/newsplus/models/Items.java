
package com.example.newsplus.models;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

@Generated("jsonschema2pojo")
public class Items implements Serializable {

    @SerializedName("count")
    @Expose
    private Integer count;
    @SerializedName("total")
    @Expose
    private Integer total;
    @SerializedName("per_page")
    @Expose
    private Integer perPage;

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Items withCount(Integer count) {
        this.count = count;
        return this;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public Items withTotal(Integer total) {
        this.total = total;
        return this;
    }

    public Integer getPerPage() {
        return perPage;
    }

    public void setPerPage(Integer perPage) {
        this.perPage = perPage;
    }

    public Items withPerPage(Integer perPage) {
        this.perPage = perPage;
        return this;
    }

}
