package com.totalawesome.infinitepops.data;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class PopFactory {

  private final static String BASE_URL = "https://api.popjam.com/v2/users/05fea6f3-4c9b-4c77-b321-8734623662ec/";
  public final static String PROJECT_URL = "https://github.com/ntphuc/InfinitePops";
  public static PopService create() {
    Retrofit retrofit = new Retrofit.Builder().baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .build();
    return retrofit.create(PopService.class);
  }
}
