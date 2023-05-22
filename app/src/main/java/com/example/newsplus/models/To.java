
package com.example.newsplus.models;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

@Generated("jsonschema2pojo")
public class To implements Serializable {

    @SerializedName("day")
    @Expose
    private Object day;
    @SerializedName("month")
    @Expose
    private Object month;
    @SerializedName("year")
    @Expose
    private Object year;

    public Object getDay() {
        return day;
    }

    public void setDay(Object day) {
        this.day = day;
    }

    public To withDay(Object day) {
        this.day = day;
        return this;
    }

    public Object getMonth() {
        return month;
    }

    public void setMonth(Object month) {
        this.month = month;
    }

    public To withMonth(Object month) {
        this.month = month;
        return this;
    }

    public Object getYear() {
        return year;
    }

    public void setYear(Object year) {
        this.year = year;
    }

    public To withYear(Object year) {
        this.year = year;
        return this;
    }

}
