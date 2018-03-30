package com.gray.basemvp.base;

import android.app.Application;

import com.gray.basemvp.http.OKHttpEngine;
import com.gray.basemvp.utils.LogUtils;

import java.util.HashMap;

import io.reactivex.functions.Consumer;
import io.reactivex.plugins.RxJavaPlugins;


/**
 * @author wjy on 2018/3/29.
 */

public class BaseApplication extends Application {
    public static final String APP_ERROR = "ApplicationError";

    @Override
    public void onCreate() {
        super.onCreate();
        setRxJavaErrorHandler();
        HashMap<String, String> headers = new HashMap<>();
        headers.put("JOKE", "RentCloud!");
        headers.put("Device", "android");
        headers.put("Authorization", "5abdda523f2f1_1522391634");
        headers.put("Accept", "Accept");
        OKHttpEngine.init(headers);
    }

    private void setRxJavaErrorHandler() {
        RxJavaPlugins.setErrorHandler(new Consumer<Throwable>() {
            @Override
            public void accept(Throwable throwable) throws Exception {
                LogUtils.e(APP_ERROR, throwable.getLocalizedMessage());
            }
        });
    }
}