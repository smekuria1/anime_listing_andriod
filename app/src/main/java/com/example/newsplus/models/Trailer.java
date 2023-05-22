
package com.example.newsplus.models;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

@Generated("jsonschema2pojo")
public class Trailer implements Serializable {

    @SerializedName("youtube_id")
    @Expose
    private String youtubeId;
    @SerializedName("url")
    @Expose
    private String url;
    @SerializedName("embed_url")
    @Expose
    private String embedUrl;
    @SerializedName("images")
    @Expose
    private Images__1 images;

    public String getYoutubeId() {
        return youtubeId;
    }

    public void setYoutubeId(String youtubeId) {
        this.youtubeId = youtubeId;
    }

    public Trailer withYoutubeId(String youtubeId) {
        this.youtubeId = youtubeId;
        return this;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Trailer withUrl(String url) {
        this.url = url;
        return this;
    }

    public String getEmbedUrl() {
        return embedUrl;
    }

    public void setEmbedUrl(String embedUrl) {
        this.embedUrl = embedUrl;
    }

    public Trailer withEmbedUrl(String embedUrl) {
        this.embedUrl = embedUrl;
        return this;
    }

    public Images__1 getImages() {
        return images;
    }

    public void setImages(Images__1 images) {
        this.images = images;
    }

    public Trailer withImages(Images__1 images) {
        this.images = images;
        return this;
    }

}
