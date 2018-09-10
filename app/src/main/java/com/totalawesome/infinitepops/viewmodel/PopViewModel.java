package com.totalawesome.infinitepops.viewmodel;

import android.content.Context;
import android.databinding.ObservableField;
import android.databinding.ObservableInt;
import android.support.annotation.NonNull;
import android.view.View;

import com.totalawesome.infinitepops.PopApplication;
import com.totalawesome.infinitepops.R;
import com.totalawesome.infinitepops.data.PopService;
import com.totalawesome.infinitepops.model.Pop;
import com.totalawesome.infinitepops.model.response.PopResponse;
import com.totalawesome.infinitepops.utils.LogUtils;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

public class PopViewModel extends Observable {

    public ObservableInt popProgress;
    public ObservableInt popRecycler;
    public ObservableInt popLabel;
    public ObservableField<String> messageLabel;

    private List<Pop> popList;
    private Context context;
    private CompositeDisposable compositeDisposable = new CompositeDisposable();

    public PopViewModel(@NonNull Context context) {

        this.context = context;
        this.popList = new ArrayList<>();
        popProgress = new ObservableInt(View.GONE);
        popRecycler = new ObservableInt(View.GONE);
        popLabel = new ObservableInt(View.VISIBLE);
        messageLabel = new ObservableField<>(context.getString(R.string.default_loading_pop));

        initializeViews();
        fetchPopList();
    }

    public void onClickFabLoad(View view) {
        initializeViews();
        fetchPopList();
    }

    //It is "public" to show an example of test
    public void initializeViews() {
        popLabel.set(View.GONE);
        popRecycler.set(View.GONE);
        popProgress.set(View.VISIBLE);
    }

    public void fetchPopList() {

        PopApplication popApplication = PopApplication.create(context);
        PopService popService = popApplication.getPopService();

        Disposable disposable = popService.fetchHomeFeed()
                .subscribeOn(popApplication.subscribeScheduler())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<PopResponse>() {
                    @Override
                    public void accept(PopResponse popResponse) throws Exception {

                        LogUtils.i(LogUtils.TAG_HOME_FEED, "PopViewModel fetchPopList onAccept");

                        changePopDataSet(popResponse.getPopList());
                        popProgress.set(View.GONE);
                        popLabel.set(View.GONE);
                        popRecycler.set(View.VISIBLE);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        LogUtils.i(LogUtils.TAG_HOME_FEED, "PopViewModel fetchPopList onFailed " + throwable.getMessage());
                        messageLabel.set(context.getString(R.string.error_loading_pop));
                        popProgress.set(View.GONE);
                        popLabel.set(View.VISIBLE);
                        popRecycler.set(View.GONE);
                    }
                });

        compositeDisposable.add(disposable);
    }

    public void getMorePops(String lastId) {

        PopApplication popApplication = PopApplication.create(context);
        PopService popService = popApplication.getPopService();

        Disposable disposable = popService.getMoreHomeFeed(lastId)
                .subscribeOn(popApplication.subscribeScheduler())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<PopResponse>() {
                    @Override
                    public void accept(PopResponse popResponse) throws Exception {

                        LogUtils.i(LogUtils.TAG_HOME_FEED, "PopViewModel getMorePops onAccept size " + popResponse.getPopList().size());
                        changePopDataSet(popResponse.getPopList());

                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        LogUtils.i(LogUtils.TAG_HOME_FEED, "PopViewModel getMorePops onFailed " + throwable.getMessage());

                    }
                });

        compositeDisposable.add(disposable);
    }

    private void changePopDataSet(List<Pop> pops) {

        popList.addAll(pops);
        setChanged();
        Boolean moreDataAvailable = Boolean.valueOf(true);
        if (pops.size() == 0)
            moreDataAvailable = Boolean.valueOf(false);
        notifyObservers(moreDataAvailable);
    }

    public List<Pop> getPopList() {
        return popList;
    }

    private void unSubscribeFromObservable() {
        if (compositeDisposable != null && !compositeDisposable.isDisposed()) {
            compositeDisposable.dispose();
        }
    }

    public void reset() {
        unSubscribeFromObservable();
        compositeDisposable = null;
        context = null;
    }


}
