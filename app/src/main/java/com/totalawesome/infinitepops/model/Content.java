package com.totalawesome.infinitepops.model;

import com.google.gson.annotations.SerializedName;

public class Content {
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    public String getContentUrl() {
        return contentUrl;
    }

    public void setContentUrl(String contentUrl) {
        this.contentUrl = contentUrl;
    }

    public String getLeaderboardUrl() {
        return leaderboardUrl;
    }

    public void setLeaderboardUrl(String leaderboardUrl) {
        this.leaderboardUrl = leaderboardUrl;
    }

    public boolean isRequiresLandscape() {
        return requiresLandscape;
    }

    public void setRequiresLandscape(boolean requiresLandscape) {
        this.requiresLandscape = requiresLandscape;
    }

    public boolean isHideBanner() {
        return hideBanner;
    }

    public void setHideBanner(boolean hideBanner) {
        this.hideBanner = hideBanner;
    }

    @SerializedName("id") private String id;

    @SerializedName("contentType") private String contentType;

    @SerializedName("contentUrl") private String contentUrl;

    @SerializedName("leaderboardUrl") private String leaderboardUrl;

    @SerializedName("requiresLandscape") private boolean requiresLandscape;

    @SerializedName("hideBanner") private boolean hideBanner;
}
