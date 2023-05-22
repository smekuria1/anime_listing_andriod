
package com.example.newsplus.models;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

@Generated("jsonschema2pojo")
public class Prop implements Serializable {

    @SerializedName("from")
    @Expose
    private From from;
    @SerializedName("to")
    @Expose
    private To to;

    public From getFrom() {
        return from;
    }

    public void setFrom(From from) {
        this.from = from;
    }

    public Prop withFrom(From from) {
        this.from = from;
        return this;
    }

    public To getTo() {
        return to;
    }

    public void setTo(To to) {
        this.to = to;
    }

    public Prop withTo(To to) {
        this.to = to;
        return this;
    }

}
