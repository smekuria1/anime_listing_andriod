
package com.example.newsplus.models;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

@Generated("jsonschema2pojo")
public class Images  implements Serializable {

    @SerializedName("jpg")
    @Expose
    private Jpg jpg;
    @SerializedName("webp")
    @Expose
    private Webp webp;

    public Jpg getJpg() {
        return jpg;
    }

    public void setJpg(Jpg jpg) {
        this.jpg = jpg;
    }

    public Images withJpg(Jpg jpg) {
        this.jpg = jpg;
        return this;
    }

    public Webp getWebp() {
        return webp;
    }

    public void setWebp(Webp webp) {
        this.webp = webp;
    }

    public Images withWebp(Webp webp) {
        this.webp = webp;
        return this;
    }

}
