
package com.example.jamessmith.newsfeedexample.rest.model;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Article {

    @SerializedName("guid")
    @Expose
    private String guid;
    @SerializedName("state")
    @Expose
    private String state;
    @SerializedName("headline_override")
    @Expose
    private String headlineOverride;
    @SerializedName("headline")
    @Expose
    private String headline;
    @SerializedName("url")
    @Expose
    private String url;
    @SerializedName("link")
    @Expose
    private String link;
    @SerializedName("authors")
    @Expose
    private List<Author> authors = null;
    @SerializedName("updated_date")
    @Expose
    private String updatedDate;
    @SerializedName("editorial_priority")
    @Expose
    private String editorialPriority;
    @SerializedName("short_headline")
    @Expose
    private String shortHeadline;
    @SerializedName("sub_headline")
    @Expose
    private String subHeadline;
    @SerializedName("author")
    @Expose
    private String author;
    @SerializedName("comments_setting")
    @Expose
    private String commentsSetting;
    @SerializedName("publish_date")
    @Expose
    private String publishDate;
    @SerializedName("topics")
    @Expose
    private List<String> topics = null;
    @SerializedName("tags")
    @Expose
    private List<String> tags = null;
    @SerializedName("section")
    @Expose
    private String section;
    @SerializedName("section_url")
    @Expose
    private String sectionUrl;
    @SerializedName("image")
    @Expose
    private Image image;
    @SerializedName("video")
    @Expose
    private Video video;
    @SerializedName("body")
    @Expose
    private String body;
    @SerializedName("author_location")
    @Expose
    private String authorLocation;
    @SerializedName("local_caption")
    @Expose
    private String localCaption;

    public String getGuid() {
        return guid;
    }

    public void setGuid(String guid) {
        this.guid = guid;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getHeadlineOverride() {
        return headlineOverride;
    }

    public void setHeadlineOverride(String headlineOverride) {
        this.headlineOverride = headlineOverride;
    }

    public String getHeadline() {
        return headline;
    }

    public void setHeadline(String headline) {
        this.headline = headline;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public List<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(List<Author> authors) {
        this.authors = authors;
    }

    public String getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(String updatedDate) {
        this.updatedDate = updatedDate;
    }

    public String getEditorialPriority() {
        return editorialPriority;
    }

    public void setEditorialPriority(String editorialPriority) {
        this.editorialPriority = editorialPriority;
    }

    public String getShortHeadline() {
        return shortHeadline;
    }

    public void setShortHeadline(String shortHeadline) {
        this.shortHeadline = shortHeadline;
    }

    public String getSubHeadline() {
        return subHeadline;
    }

    public void setSubHeadline(String subHeadline) {
        this.subHeadline = subHeadline;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getCommentsSetting() {
        return commentsSetting;
    }

    public void setCommentsSetting(String commentsSetting) {
        this.commentsSetting = commentsSetting;
    }

    public String getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(String publishDate) {
        this.publishDate = publishDate;
    }

    public List<String> getTopics() {
        return topics;
    }

    public void setTopics(List<String> topics) {
        this.topics = topics;
    }

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    public String getSection() {
        return section;
    }

    public void setSection(String section) {
        this.section = section;
    }

    public String getSectionUrl() {
        return sectionUrl;
    }

    public void setSectionUrl(String sectionUrl) {
        this.sectionUrl = sectionUrl;
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    public Video getVideo() {
        return video;
    }

    public void setVideo(Video video) {
        this.video = video;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getAuthorLocation() {
        return authorLocation;
    }

    public void setAuthorLocation(String authorLocation) {
        this.authorLocation = authorLocation;
    }

    public String getLocalCaption() {
        return localCaption;
    }

    public void setLocalCaption(String localCaption) {
        this.localCaption = localCaption;
    }

}
