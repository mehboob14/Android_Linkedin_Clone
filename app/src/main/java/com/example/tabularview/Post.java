package com.example.tabularview;

public class Post {
    private String username;
    private String postTime;
    private String postContent;
    private String profilePicUrl;

    public Post() {

    }

    public Post(String username, String postTime, String postContent, String profilePicUrl) {
        this.username = username;
        this.postTime = postTime;
        this.postContent = postContent;
        this.profilePicUrl = profilePicUrl;
    }

    public String getUsername() {
        return username;
    }

    public String getPostTime() {
        return postTime;
    }

    public String getPostContent() {
        return postContent;
    }

    public String getProfilePicUrl() {
        return profilePicUrl;
    }
}
