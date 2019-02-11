package com.gray.basemvp.observer;

import com.gray.basemvp.base.BasePresenter;
import com.gray.basemvp.base.BaseMVPView;
import com.gray.basemvp.base.IClassTAG;
import com.gray.basemvp.error.ErrorManager;
import com.gray.basemvp.error.NetResponseException;
import com.gray.basemvp.utils.LogUtils;

import java.lang.ref.SoftReference;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;


/**
 * @author wjy on 2018/3/19.
 */

public abstract class SimpleObservable<T> implements Observer<T> {

    private SoftReference<BaseMVPView> softView;
    private SoftReference<BasePresenter> softPresenter;
    private Disposable disposable;

    public SimpleObservable(BaseMVPView view, BasePresenter presenter) {
        softView = new SoftReference<>(view);
        softPresenter = new SoftReference<>(presenter);
    }


    @Override
    public void onSubscribe(Disposable d) {
        if (softView.get() == null) {
            d.dispose();
        } else {
            BasePresenter presenter = softPresenter.get();
            presenter.add(d);
            disposable = d;
        }
    }

    @Override
    public void onComplete() {
        LogUtils.e("步骤", "onComplete");
        removeDisposable();
    }


    @Override
    public void onError(Throwable e) {
        if (e instanceof NetResponseException) {
            NetResponseException exception = (NetResponseException) e;
            softView.get().error(ErrorManager.getInstance().getMsg(exception.getCode()));
        } else {
            if (softView.get() != null && softView.get() instanceof IClassTAG) {
                IClassTAG tag = (IClassTAG) softView.get();
                LogUtils.e(tag, e.getLocalizedMessage());
            }
            softView.get().error(ErrorManager.getInstance().getCommonMsg());
        }
        removeDisposable();
    }

    //移除Disposable
    private void removeDisposable() {
        if (disposable != null) {
            softPresenter.get().remove(disposable);
            disposable = null;
        }
    }

}
