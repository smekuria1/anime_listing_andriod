
package com.example.newsplus.models;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

@Generated("jsonschema2pojo")
public class Title implements Serializable {

    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("title")
    @Expose
    private String title;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Title withType(String type) {
        this.type = type;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Title withTitle(String title) {
        this.title = title;
        return this;
    }

}
