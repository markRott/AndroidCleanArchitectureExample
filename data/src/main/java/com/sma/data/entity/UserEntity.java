package com.sma.data.entity;

import com.google.gson.annotations.SerializedName;

/**
 * Created by sma on 06.09.17.
 */

public class UserEntity {

    @SerializedName("id")
    private int userId;

    @SerializedName("cover_url")
    private String coverUrl;

    @SerializedName("full_name")
    private String fullname;

    @SerializedName("description")
    private String description;

    @SerializedName("followers")
    private int followers;

    @SerializedName("email")
    private String email;

    public UserEntity() {
        //empty
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public void setCoverUrl(String coverUrl) {
        this.coverUrl = coverUrl;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setFollowers(int followers) {
        this.followers = followers;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getUserId() {
        return userId;
    }

    public String getCoverUrl() {
        return coverUrl;
    }

    public String getFullname() {
        return fullname;
    }

    public String getDescription() {
        return description;
    }

    public int getFollowers() {
        return followers;
    }

    public String getEmail() {
        return email;
    }
}
