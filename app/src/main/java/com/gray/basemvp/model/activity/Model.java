package com.gray.basemvp.model.activity;

import com.gray.basemvp.base.BaseMVPModel;

import io.reactivex.Observable;


/**
 * @author wjy on 2018/3/19.
 */

public class Model extends BaseMVPModel {
    public Observable<Integer> get() {
        return Observable.just(1);
    }

    public Observable<Bean> getSlow() throws InterruptedException {
        return getInterfaces().getStories("0","4");
    }
}
