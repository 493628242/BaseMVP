package com.gray.basemvp.http.converter;

import android.support.annotation.NonNull;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.gray.basemvp.base.BaseBean;
import com.gray.basemvp.error.ErrorMsg;
import com.gray.basemvp.error.NetResponseException;
import com.gray.basemvp.http.config.ConfigProperty;
import com.gray.basemvp.utils.LogUtils;

import java.io.IOException;
import java.lang.reflect.Type;

import okhttp3.ResponseBody;
import retrofit2.Converter;

/**
 * Created by wjy on 2017/10/29.
 * 响应的转换工厂
 */

class DataResponseBodyConverter<T> implements Converter<ResponseBody, T> {
    private final Gson gson;
    private Type type;
    public final String TAG = getClass().getSimpleName();

    DataResponseBodyConverter(Gson gson, Type type) {
        this.gson = gson;
        this.type = type;
    }

    @Override
    public T convert(@NonNull ResponseBody value) throws IOException {
        if (!BaseBean.class.isAssignableFrom(TypeToken.get(type).getRawType())) {
            throw new NetResponseException(ErrorMsg.ERROR_BEAN_ILLEGAL.getCode());
        } else {
            String jsonString = value.string();
            LogUtils.i(TAG, jsonString);
            BaseBean bean = gson.fromJson(jsonString, type);
            if (bean.getApiCode() != ConfigProperty.SUCCESS) {
                throw new NetResponseException(bean.getApiCode());
            }
            return (T) bean;
        }
    }
}
