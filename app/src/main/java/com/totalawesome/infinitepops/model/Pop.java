package com.totalawesome.infinitepops.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class Pop implements Serializable {

  @SerializedName("id") private String id;

  @SerializedName("date") private long date;



  @SerializedName("text") private String text;

  @SerializedName("imageSrc") private String imageSrc;

  @SerializedName("postingUserId") private String postingUserId;

 // @SerializedName("stickerPositions") private List<String> stickerPositions;

  @SerializedName("containPhotos") private boolean containPhotos;

  @SerializedName("videoSrc") private List<String> videoSrc;

  @SerializedName("thumbnailSrc") private List<String> thumbnailSrc;

  @SerializedName("videoDuration") private int videoDuration;

  //@SerializedName("subItems") private List<Pop> subItems;

  @SerializedName("likeCount") private int likeCount;

  @SerializedName("selfLiked") private boolean selfLiked;

  @SerializedName("commentCount") private int commentCount;

  @SerializedName("viewCount") private int viewCount;

  @SerializedName("frontEndId") private String frontEndId;

  @SerializedName("rejamCount") private int rejamCount;

  @SerializedName("selfRejamed") private boolean selfRejamed;

  @SerializedName("videoViewQuartitles") private String videoViewQuartitles;

 // @SerializedName("rejamOf") private Pop rejamOf;

  //@SerializedName("richContent") private Content richContent;

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public long getDate() {
    return date;
  }

  public void setDate(long date) {
    this.date = date;
  }


  public String getText() {
    return text;
  }

  public void setText(String text) {
    this.text = text;
  }

  public String getImageSrc() {
    return imageSrc;
  }

  public void setImageSrc(String imageSrc) {
    this.imageSrc = imageSrc;
  }

    public String getPostingUserId() {
    return postingUserId;
  }

  public void setPostingUserId(String postingUserId) {
    this.postingUserId = postingUserId;
  }

//  public List<String> getStickerPositions() {
//    return stickerPositions;
//  }
//
//  public void setStickerPositions(List<String> stickerPositions) {
//    this.stickerPositions = stickerPositions;
//  }

  public boolean isContainPhotos() {
    return containPhotos;
  }

  public void setContainPhotos(boolean containPhotos) {
    this.containPhotos = containPhotos;
  }

  public List<String> getVideoSrc() {
    return videoSrc;
  }

  public void setVideoSrc(List<String> videoSrc) {
    this.videoSrc = videoSrc;
  }

  public List<String> getThumbnailSrc() {
    return thumbnailSrc;
  }

  public void setThumbnailSrc(List<String> thumbnailSrc) {
    this.thumbnailSrc = thumbnailSrc;
  }

  public int getVideoDuration() {
    return videoDuration;
  }

  public void setVideoDuration(int videoDuration) {
    this.videoDuration = videoDuration;
  }

//  public List<Pop> getSubItems() {
//    return subItems;
//  }
//
//  public void setSubItems(List<Pop> subItems) {
//    this.subItems = subItems;
//  }

  public int getLikeCount() {
    return likeCount;
  }

  public void setLikeCount(int likeCount) {
    this.likeCount = likeCount;
  }

  public boolean isSelfLiked() {
    return selfLiked;
  }

  public void setSelfLiked(boolean selfLiked) {
    this.selfLiked = selfLiked;
  }

  public int getCommentCount() {
    return commentCount;
  }

  public void setCommentCount(int commentCount) {
    this.commentCount = commentCount;
  }

  public int getViewCount() {
    return viewCount;
  }

  public void setViewCount(int viewCount) {
    this.viewCount = viewCount;
  }

  public String getFrontEndId() {
    return frontEndId;
  }

  public void setFrontEndId(String frontEndId) {
    this.frontEndId = frontEndId;
  }

  public int getRejamCount() {
    return rejamCount;
  }

  public void setRejamCount(int rejamCount) {
    this.rejamCount = rejamCount;
  }

  public boolean isSelfRejamed() {
    return selfRejamed;
  }

  public void setSelfRejamed(boolean selfRejamed) {
    this.selfRejamed = selfRejamed;
  }

  public String getVideoViewQuartitles() {
    return videoViewQuartitles;
  }

  public void setVideoViewQuartitles(String videoViewQuartitles) {
    this.videoViewQuartitles = videoViewQuartitles;
  }

//  public Pop getRejamOf() {
//    return rejamOf;
//  }
//
//  public void setRejamOf(Pop rejamOf) {
//    this.rejamOf = rejamOf;
//  }
//
//  public Content getRichContent() {
//    return richContent;
//  }
//
//  public void setRichContent(Content richContent) {
//    this.richContent = richContent;
//  }
}
