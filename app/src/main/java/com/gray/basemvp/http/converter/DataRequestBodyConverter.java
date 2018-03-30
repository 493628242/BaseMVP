package com.gray.basemvp.http.converter;


import android.support.annotation.NonNull;

import com.google.gson.Gson;

import java.io.IOException;
import java.util.HashMap;

import okhttp3.RequestBody;
import retrofit2.Converter;

/**
 * Created by wjy on 2017/11/12.
 * 请求的转换工厂
 */

class DataRequestBodyConverter implements Converter<HashMap<String, Object>, RequestBody> {
    private final Gson gson;

    DataRequestBodyConverter(Gson gson) {
        this.gson = gson;
    }

    @Override
    public RequestBody convert(@NonNull HashMap<String, Object> value) throws IOException {
        return null;
    }

}
