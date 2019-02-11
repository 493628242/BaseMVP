package com.gray.basemvp.utils;

import com.gray.basemvp.base.BaseMVPView;

import java.lang.ref.SoftReference;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.ObservableTransformer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * @author wjy on 2018/11/8/008.
 */
public class Transformer<T> implements ObservableTransformer<T, T> {
    private SoftReference<BaseMVPView> mView;

    public Transformer(BaseMVPView mView) {
        this.mView = new SoftReference<>(mView);
    }


    @Override
    public ObservableSource<T> apply(Observable<T> upstream) {
        return upstream.subscribeOn(Schedulers.io())
                .doOnSubscribe(new Consumer<Disposable>() {
                    @Override
                    public void accept(Disposable disposable) throws Exception {
                        if (mView.get() != null) {
                            mView.get().load();
                        }
                    }
                }).observeOn(AndroidSchedulers.mainThread());
    }
}
