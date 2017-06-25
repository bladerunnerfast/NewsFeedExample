
package com.example.jamessmith.newsfeedexample.rest.model;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Model {

    @SerializedName("feeds")
    @Expose
    private Feeds feeds;
    @SerializedName("articles")
    @Expose
    private List<Article> articles = null;
    @SerializedName("section")
    @Expose
    private String section;
    @SerializedName("url")
    @Expose
    private String url;

    public Feeds getFeeds() {
        return feeds;
    }

    public void setFeeds(Feeds feeds) {
        this.feeds = feeds;
    }

    public List<Article> getArticles() {
        return articles;
    }

    public void setArticles(List<Article> articles) {
        this.articles = articles;
    }

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
