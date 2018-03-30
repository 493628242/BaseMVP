package com.gray.basemvp.http;

import com.gray.basemvp.http.config.UrlConfig;
import com.gray.basemvp.model.activity.Bean;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by wjy on 2017/2/1.
 * 定义具体的接口
 */
public interface HttpInterfaces {
    @GET(UrlConfig.STORIES)
    Observable<Bean> getStories(@Query("start") String start, @Query("len") String len);
}
