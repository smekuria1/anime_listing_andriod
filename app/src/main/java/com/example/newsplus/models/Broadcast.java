
package com.example.newsplus.models;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

@Generated("jsonschema2pojo")
public class Broadcast implements Serializable {

    @SerializedName("day")
    @Expose
    private String day;
    @SerializedName("time")
    @Expose
    private String time;
    @SerializedName("timezone")
    @Expose
    private String timezone;
    @SerializedName("string")
    @Expose
    private String string;

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public Broadcast withDay(String day) {
        this.day = day;
        return this;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public Broadcast withTime(String time) {
        this.time = time;
        return this;
    }

    public String getTimezone() {
        return timezone;
    }

    public void setTimezone(String timezone) {
        this.timezone = timezone;
    }

    public Broadcast withTimezone(String timezone) {
        this.timezone = timezone;
        return this;
    }

    public String getString() {
        return string;
    }

    public void setString(String string) {
        this.string = string;
    }

    public Broadcast withString(String string) {
        this.string = string;
        return this;
    }

}
