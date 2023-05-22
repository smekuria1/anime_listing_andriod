
package com.example.newsplus.models;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

@Generated("jsonschema2pojo")
public class Aired implements Serializable {

    @SerializedName("from")
    @Expose
    private String from;
    @SerializedName("to")
    @Expose
    private Object to;
    @SerializedName("prop")
    @Expose
    private Prop prop;
    @SerializedName("string")
    @Expose
    private String string;

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public Aired withFrom(String from) {
        this.from = from;
        return this;
    }

    public Object getTo() {
        return to;
    }

    public void setTo(Object to) {
        this.to = to;
    }

    public Aired withTo(Object to) {
        this.to = to;
        return this;
    }

    public Prop getProp() {
        return prop;
    }

    public void setProp(Prop prop) {
        this.prop = prop;
    }

    public Aired withProp(Prop prop) {
        this.prop = prop;
        return this;
    }

    public String getString() {
        return string;
    }

    public void setString(String string) {
        this.string = string;
    }

    public Aired withString(String string) {
        this.string = string;
        return this;
    }

}
