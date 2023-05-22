
package com.example.newsplus.models;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

@Generated("jsonschema2pojo")
public class From implements Serializable {

    @SerializedName("day")
    @Expose
    private Integer day;
    @SerializedName("month")
    @Expose
    private Integer month;
    @SerializedName("year")
    @Expose
    private Integer year;

    public Integer getDay() {
        return day;
    }

    public void setDay(Integer day) {
        this.day = day;
    }

    public From withDay(Integer day) {
        this.day = day;
        return this;
    }

    public Integer getMonth() {
        return month;
    }

    public void setMonth(Integer month) {
        this.month = month;
    }

    public From withMonth(Integer month) {
        this.month = month;
        return this;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public From withYear(Integer year) {
        this.year = year;
        return this;
    }

}
