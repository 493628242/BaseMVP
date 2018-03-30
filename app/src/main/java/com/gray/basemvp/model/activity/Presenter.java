package com.gray.basemvp.model.activity;

import android.util.Log;

import com.gray.basemvp.base.BasePresenter;
import com.gray.basemvp.observer.SimpleObservable;
import com.gray.basemvp.utils.LogUtils;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * @author wjy on 2018/3/19.
 */

public class Presenter extends BasePresenter<View, Model> {
    public Presenter(View view) {
        super(view);
    }

    public void get() {
        model.get().subscribeOn(Schedulers.io())
                .doOnSubscribe(new Consumer<Disposable>() {
                    @Override
                    public void accept(Disposable disposable) throws Exception {
                        view.load();
                    }
                })
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new SimpleObservable<Integer>(view, this) {
                    @Override
                    public void onNext(@NonNull Integer integer) {
                        Log.e("线程", Thread.currentThread().getName());
                        view.success();
                    }
                });
    }

    public void getSlow() {
        try {
            model.getSlow().subscribeOn(Schedulers.io())
                    .doOnSubscribe(new Consumer<Disposable>() {
                        @Override
                        public void accept(Disposable disposable) throws Exception {
                            view.load();
                        }
                    })
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(new SimpleObservable<Bean>(view, this) {
                        @Override
                        public void onNext(@NonNull Bean bean) {
                            LogUtils.e("线程11", Thread.currentThread().getName());
                            LogUtils.e("code", bean.getApiCode() + "");
                            view.success();
                        }
                    });
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
