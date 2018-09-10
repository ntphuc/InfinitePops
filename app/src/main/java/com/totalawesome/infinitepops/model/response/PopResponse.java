package com.totalawesome.infinitepops.model.response;

import com.google.gson.annotations.SerializedName;
import com.totalawesome.infinitepops.model.Pop;

import java.util.List;

public class PopResponse {

  @SerializedName("feedItems") private List<Pop> popList;

  public List<Pop> getPopList() {
    return popList;
  }

  public void setPopList(List<Pop> mPopList) {
    this.popList = mPopList;
  }
}
