package com.totalawesome.infinitepops.view;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import com.totalawesome.infinitepops.R;
import com.totalawesome.infinitepops.data.PopFactory;
import com.totalawesome.infinitepops.databinding.PopActivityBinding;
import com.totalawesome.infinitepops.viewmodel.PopViewModel;

import java.util.Observable;
import java.util.Observer;

public class PopActivity extends AppCompatActivity implements Observer {

  private PopActivityBinding popActivityBinding;
  private PopViewModel popViewModel;

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    initDataBinding();
    setSupportActionBar(popActivityBinding.toolbar);
    setupListPopView(popActivityBinding.listPop);
    setupObserver(popViewModel);
  }

  private void initDataBinding() {
    popActivityBinding = DataBindingUtil.setContentView(this, R.layout.pop_activity);
    popViewModel = new PopViewModel(this);
    popActivityBinding.setMainViewModel(popViewModel);
  }

  private void setupListPopView(RecyclerView listPop) {
    PopAdapter adapter = new PopAdapter();
    listPop.setAdapter(adapter);
    listPop.setLayoutManager(new LinearLayoutManager(this));
    adapter.addLoadMoreListener(new PopAdapter.OnLoadMoreListener() {
      @Override
      public void onLoadMore() {
        popActivityBinding.listPop.post(new Runnable() {
          @Override
          public void run() {
            if (popViewModel.getPopList().size()>=1) {
              int last_index = popViewModel.getPopList().size() - 1;
              String lastId = popViewModel.getPopList().get(last_index).getId();
              popViewModel.getMorePops(lastId);
            }
          }
        });
      }
    });
  }

  public void setupObserver(Observable observable) {
    observable.addObserver(this);
  }

  @Override protected void onDestroy() {
    super.onDestroy();
    popViewModel.reset();
  }

  @Override public boolean onCreateOptionsMenu(Menu menu) {
    getMenuInflater().inflate(R.menu.main, menu);
    return true;
  }

  @Override public boolean onOptionsItemSelected(MenuItem item) {
    if (item.getItemId() == R.id.menu_github) {
      startActivityActionView();
      return true;
    }
    return super.onOptionsItemSelected(item);
  }

  private void startActivityActionView() {
    startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(PopFactory.PROJECT_URL)));
  }

  @Override public void update(Observable observable, Object data) {
    if (observable instanceof PopViewModel) {

      PopAdapter popAdapter = (PopAdapter) popActivityBinding.listPop.getAdapter();
      PopViewModel popViewModel = (PopViewModel) observable;
      popAdapter.setPopList(popViewModel.getPopList());
      if (data instanceof Boolean) {
        boolean moreDataAvailable = ((Boolean) data).booleanValue();
        popAdapter.setMoreDataAvailable(moreDataAvailable);
      }
    }
  }
}
