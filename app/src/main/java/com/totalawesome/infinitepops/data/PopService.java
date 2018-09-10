package com.totalawesome.infinitepops.data;

import com.totalawesome.infinitepops.model.response.PopResponse;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface PopService {

  @GET("homeFeed")
  Observable<PopResponse> fetchHomeFeed();

  @GET("homeFeed?")
  Observable<PopResponse> getMoreHomeFeed(@Query("lastId") String lastId);

}
