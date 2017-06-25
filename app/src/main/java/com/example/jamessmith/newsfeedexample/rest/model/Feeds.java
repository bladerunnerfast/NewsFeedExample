
package com.example.jamessmith.newsfeedexample.rest.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Feeds {

    @SerializedName("section")
    @Expose
    private String section;
    @SerializedName("url")
    @Expose
    private String url;

    public String getSection() {
        return section;
    }

    public void setSection(String section) {
        this.section = section;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

}
