
package com.example.newsplus.models;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

@Generated("jsonschema2pojo")
public class Images__1 implements Serializable {

    @SerializedName("image_url")
    @Expose
    private String imageUrl;
    @SerializedName("small_image_url")
    @Expose
    private String smallImageUrl;
    @SerializedName("medium_image_url")
    @Expose
    private String mediumImageUrl;
    @SerializedName("large_image_url")
    @Expose
    private String largeImageUrl;
    @SerializedName("maximum_image_url")
    @Expose
    private String maximumImageUrl;

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public Images__1 withImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
        return this;
    }

    public String getSmallImageUrl() {
        return smallImageUrl;
    }

    public void setSmallImageUrl(String smallImageUrl) {
        this.smallImageUrl = smallImageUrl;
    }

    public Images__1 withSmallImageUrl(String smallImageUrl) {
        this.smallImageUrl = smallImageUrl;
        return this;
    }

    public String getMediumImageUrl() {
        return mediumImageUrl;
    }

    public void setMediumImageUrl(String mediumImageUrl) {
        this.mediumImageUrl = mediumImageUrl;
    }

    public Images__1 withMediumImageUrl(String mediumImageUrl) {
        this.mediumImageUrl = mediumImageUrl;
        return this;
    }

    public String getLargeImageUrl() {
        return largeImageUrl;
    }

    public void setLargeImageUrl(String largeImageUrl) {
        this.largeImageUrl = largeImageUrl;
    }

    public Images__1 withLargeImageUrl(String largeImageUrl) {
        this.largeImageUrl = largeImageUrl;
        return this;
    }

    public String getMaximumImageUrl() {
        return maximumImageUrl;
    }

    public void setMaximumImageUrl(String maximumImageUrl) {
        this.maximumImageUrl = maximumImageUrl;
    }

    public Images__1 withMaximumImageUrl(String maximumImageUrl) {
        this.maximumImageUrl = maximumImageUrl;
        return this;
    }

}
