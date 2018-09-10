package com.totalawesome.infinitepops;

import android.app.Application;
import android.content.Context;

import com.totalawesome.infinitepops.data.PopFactory;
import com.totalawesome.infinitepops.data.PopService;

import io.reactivex.Scheduler;
import io.reactivex.schedulers.Schedulers;

public class PopApplication extends Application {

  private PopService popService;
  private Scheduler scheduler;

  private static PopApplication get(Context context) {
    return (PopApplication) context.getApplicationContext();
  }

  public static PopApplication create(Context context) {
    return PopApplication.get(context);
  }

  public PopService getPopService() {
    if (popService == null) {
      popService = PopFactory.create();
    }

    return popService;
  }

  public Scheduler subscribeScheduler() {
    if (scheduler == null) {
      scheduler = Schedulers.io();
    }

    return scheduler;
  }

  public void setPopService(PopService popService) {
    this.popService = popService;
  }

  public void setScheduler(Scheduler scheduler) {
    this.scheduler = scheduler;
  }
}
