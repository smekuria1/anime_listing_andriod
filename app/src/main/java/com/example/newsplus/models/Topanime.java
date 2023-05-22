
package com.example.newsplus.models;

import java.io.Serializable;
import java.util.List;
import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("jsonschema2pojo")
public class Topanime  implements Serializable {

    @SerializedName("pagination")
    @Expose
    private Pagination pagination;
    @SerializedName("data")
    @Expose
    private List<Datum> data;

    public Pagination getPagination() {
        return pagination;
    }

    public void setPagination(Pagination pagination) {
        this.pagination = pagination;
    }

    public Topanime withPagination(Pagination pagination) {
        this.pagination = pagination;
        return this;
    }

    public List<Datum> getData() {
        return data;
    }

    public void setData(List<Datum> data) {
        this.data = data;
    }

    public Topanime withData(List<Datum> data) {
        this.data = data;
        return this;
    }

}
