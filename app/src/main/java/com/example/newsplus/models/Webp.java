
package com.example.newsplus.models;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

@Generated("jsonschema2pojo")
public class Webp implements Serializable {

    @SerializedName("image_url")
    @Expose
    private String imageUrl;
    @SerializedName("small_image_url")
    @Expose
    private String smallImageUrl;
    @SerializedName("large_image_url")
    @Expose
    private String largeImageUrl;

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public Webp withImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
        return this;
    }

    public String getSmallImageUrl() {
        return smallImageUrl;
    }

    public void setSmallImageUrl(String smallImageUrl) {
        this.smallImageUrl = smallImageUrl;
    }

    public Webp withSmallImageUrl(String smallImageUrl) {
        this.smallImageUrl = smallImageUrl;
        return this;
    }

    public String getLargeImageUrl() {
        return largeImageUrl;
    }

    public void setLargeImageUrl(String largeImageUrl) {
        this.largeImageUrl = largeImageUrl;
    }

    public Webp withLargeImageUrl(String largeImageUrl) {
        this.largeImageUrl = largeImageUrl;
        return this;
    }

}
