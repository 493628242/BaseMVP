package com.gray.basemvp.http;

import android.os.Handler;
import android.os.Looper;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;


import java.io.IOException;
import java.util.HashMap;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * @author wjy on 2017/9/22.
 */
public class OKHttpEngine {

    private static OkHttpClient okHttpClient;
    private static OkHttpClient.Builder builder;
    private static HashMap<String, String> headers;

    private OKHttpEngine() {
    }

    /**
     * 获取OkHttp实例
     *
     * @return okhttp
     */
    public static OkHttpClient getInstance() {
        if (okHttpClient == null) {
            synchronized (OKHttpEngine.class) {
                if (okHttpClient == null) {
                    if (builder == null) {
                        throw new RuntimeException("请先init本类");
                    } else {
                        okHttpClient = builder
                                .addInterceptor(new Interceptor() {
                                    @Override
                                    public Response intercept(@NonNull Chain chain) throws IOException {
                                        Request request = chain.request();
                                        if (headers != null && headers.size() != 0) {
                                            Request.Builder builder = request.newBuilder();
                                            Set<String> set = headers.keySet();
                                            for (String key :
                                                    set) {
                                                String value = headers.get(key);
                                                builder.addHeader(key, value);
                                            }
                                            request = builder.build();
                                        }
                                        Log.e("request", request.url().toString());
                                        return chain.proceed(request);
                                    }
                                })
                                .build();
                    }
                }
            }
        }
        return okHttpClient;
    }

    public static void init(@Nullable HashMap<String, String> headers) {
        builder = new OkHttpClient.Builder()
                .connectTimeout(30000L, TimeUnit.MILLISECONDS)
                .readTimeout(10000L, TimeUnit.MILLISECONDS)
                .retryOnConnectionFailure(true);
        OKHttpEngine.headers = headers;
    }
}
