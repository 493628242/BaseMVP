package com.gray.basemvp.http;


import com.gray.basemvp.http.config.UrlConfig;
import com.gray.basemvp.http.converter.DataConverterFactory;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

/**
 * @author wjy on 2016/11/15.
 */

public class HttpUtils {
    private static volatile HttpUtils singleton;

    private HttpInterfaces iApi;
    private Retrofit retrofit;

    private HttpUtils() {
        init();
    }

    /**
     * 获取HttpUtil对象 单例模式
     *
     * @return
     */
    public static HttpUtils getInstance() {
        if (singleton == null) {
            synchronized (HttpUtils.class) {
                if (singleton == null) {
                    singleton = new HttpUtils();
                }
            }
        }
        return singleton;
    }

    /**
     * 初始化Retrofit
     */
    private void init() {
        retrofit = new Retrofit.Builder()
                .baseUrl(UrlConfig.BASE_URL)
                .addConverterFactory(DataConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(OKHttpEngine.getInstance())
                .build();

    }

    /**
     * 获取HttpInterface接口对象
     *
     * @return
     */
    public HttpInterfaces getHttpInterfaces() {
        if (iApi == null)
            iApi = retrofit.create(HttpInterfaces.class);
        return iApi;
    }

}
