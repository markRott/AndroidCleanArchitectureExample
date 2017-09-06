package com.stdmar.domain.models;

/**
 * Created by sma on 05.09.17.
 */

public class UserDomainModel {

    private int userId;
    private int followers;

    private String email;
    private String coverUrl;
    private String fullName;
    private String description;

    public UserDomainModel(int userId) {

        this.userId = userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public void setFollowers(int followers) {
        this.followers = followers;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setCoverUrl(String coverUrl) {
        this.coverUrl = coverUrl;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getUserId() {
        return userId;
    }

    public int getFollowers() {
        return followers;
    }

    public String getEmail() {
        return email;
    }

    public String getCoverUrl() {
        return coverUrl;
    }

    public String getFullName() {
        return fullName;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return "UserDomainModel{" +
                "userId=" + userId +
                ", followers=" + followers +
                ", email='" + email + '\'' +
                ", coverUrl='" + coverUrl + '\'' +
                ", fullName='" + fullName + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
