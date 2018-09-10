package com.totalawesome.infinitepops.viewmodel;

import android.content.Context;
import android.databinding.BaseObservable;
import android.databinding.BindingAdapter;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.totalawesome.infinitepops.R;
import com.totalawesome.infinitepops.model.Pop;
import com.totalawesome.infinitepops.utils.CommonUtils;


public class ItemPopViewModel extends BaseObservable {

  private Pop pop;
  private Context context;

  public ItemPopViewModel(Pop pop, Context context) {
    this.pop = pop;
    this.context = context;
  }

  public String getText() {

    return pop.getText();
  }

  public String getDate() {


    return CommonUtils.convertLongToDate (pop.getDate());
  }

  public String getImageSrc() {
    return pop.getImageSrc();
  }


  @BindingAdapter("imageSrc") public static void setImageUrl(ImageView imageView, String url) {
//    if (url==null || "".equals(url))
//      imageView.setImageResource(R.drawable.no_image);
//      else
    Glide.with(imageView.getContext()).load(url).into(imageView);
  }

  public void setPop(Pop pop) {
    this.pop = pop;
    notifyChange();
  }
}
