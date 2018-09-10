package com.totalawesome.infinitepops.view;

import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.totalawesome.infinitepops.R;
import com.totalawesome.infinitepops.databinding.ItemPopBinding;
import com.totalawesome.infinitepops.model.Pop;
import com.totalawesome.infinitepops.utils.LogUtils;
import com.totalawesome.infinitepops.viewmodel.ItemPopViewModel;

import java.util.Collections;
import java.util.List;

public class PopAdapter extends RecyclerView.Adapter<PopAdapter.PopAdapterViewHolder> {

  private List<Pop> popList;

  // for load more function
  private OnLoadMoreListener onLoadMoreListener;
  // this variable to show loading data is running or not
  boolean isLoading = false;
  // check data loadmore is end or not
  boolean isMoreDataAvailable = true;


  public PopAdapter() {
    this.popList = Collections.emptyList();
  }

  @Override public PopAdapterViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
    ItemPopBinding itemPopBinding =
        DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.item_pop,
            parent, false);
    return new PopAdapterViewHolder(itemPopBinding);
  }

  @Override public void onBindViewHolder(PopAdapterViewHolder holder, int position) {
    LogUtils.i(LogUtils.TAG_HOME_FEED, "PopViewModel onBindViewHolder position "+position+" isLoading "+ isLoading + "isMoreDataAvailable" + isMoreDataAvailable);

    if (position >= getItemCount() - 1 && isMoreDataAvailable && !isLoading && onLoadMoreListener != null) {


      isLoading = true;
      onLoadMoreListener.onLoadMore();
    }
    holder.bindPop(popList.get(position));
  }

  @Override public int getItemCount() {
    return popList.size();
  }

  public void setPopList(List<Pop> popList) {
    this.popList = popList;
    notifyDataSetChanged();
    // set is Loading = false is finished loading data to prepare for next call loadmore
    isLoading = false;
  }
  /* method for handling loadMore items :  addLoadMoreListener, setMoreDataAvailable*/
  public void addLoadMoreListener(OnLoadMoreListener onLoadMoreListener) {
    this.onLoadMoreListener = onLoadMoreListener;
  }
  public void setMoreDataAvailable(boolean moreDataAvailable) {
    isMoreDataAvailable = moreDataAvailable;
  }


  public static class PopAdapterViewHolder extends RecyclerView.ViewHolder {
    ItemPopBinding mItemPopBinding;

    public PopAdapterViewHolder(ItemPopBinding itemPopBinding) {
      super(itemPopBinding.getRoot());
      this.mItemPopBinding = itemPopBinding;
    }

    void bindPop(Pop pop) {

      if (mItemPopBinding.getPopViewModel() == null) {
        mItemPopBinding.setPopViewModel(
            new ItemPopViewModel(pop, itemView.getContext()));
      } else {
        mItemPopBinding.getPopViewModel().setPop(pop);
      }
    }
  }

  public interface OnLoadMoreListener {
    void onLoadMore();
  }
}
