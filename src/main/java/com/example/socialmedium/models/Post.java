package com.example.socialmedium.models;

import java.util.Date;

public class Post {
    private int postId;
    private int profileId;
    private String title, content;
    private Date createdAt;

    public Post() {
    }

    public int getPostId() {
        return postId;
    }

    public int getProfileId() {
        return profileId;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setPostId(int postId) {
        this.postId = postId;
    }

    public void setProfileId(int profileId) {
        this.profileId = profileId;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }
}
