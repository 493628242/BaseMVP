package com.gray.basemvp.model.activity;

import com.gray.basemvp.base.BaseModel;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.annotations.NonNull;


/**
 * @author wjy on 2018/3/19.
 */

public class Model extends BaseModel {
    public Observable<Integer> get() {
        return Observable.just(1);
    }

    public Observable<Bean> getSlow() throws InterruptedException {
        return getInterfaces().getStories("0","4");
    }
}
