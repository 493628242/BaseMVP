package com.gray.basemvp.base;

import org.reactivestreams.Subscriber;

import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

/**
 * @author wjy on 2017/9/22.
 */

public abstract class BasePresenter<V extends BaseView, M extends BaseModel> {

    protected V view;
    protected M model;
    private CompositeDisposable disposables;

    @SuppressWarnings("unchecked")
    public BasePresenter(V view) {
        this.view = view;
        try {
            //反射创建model对象
            ParameterizedType pt = (ParameterizedType) this.getClass().getGenericSuperclass();
            Class<M> clazz = (Class<M>) pt.getActualTypeArguments()[1];
            model = clazz.newInstance();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        disposables = new CompositeDisposable();
    }

    public void add(Disposable disposable) {
        disposables.add(disposable);
    }

    public void remove(Disposable disposable) {
        disposables.remove(disposable);
    }

    public void resetAll() {
        disposables.clear();
    }
}
