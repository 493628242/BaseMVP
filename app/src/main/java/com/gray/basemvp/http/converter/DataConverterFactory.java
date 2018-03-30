package com.gray.basemvp.http.converter;

import android.support.annotation.Nullable;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.reflect.TypeToken;

import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import java.util.HashMap;

import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Converter;
import retrofit2.Retrofit;

/**
 * Created by wjy on 2017/10/29.
 * 用于处理数据的转换工厂
 */

public class DataConverterFactory extends Converter.Factory {


    public final String TAG = getClass().getSimpleName();

    public static DataConverterFactory create() {
        return create(new Gson());
    }

    private static DataConverterFactory create(Gson gson) {
        if (gson == null) throw new NullPointerException("gson == null");
        return new DataConverterFactory(gson);
    }

    private final Gson gson;

    private DataConverterFactory(Gson gson) {
        this.gson = gson;
    }

    @Override
    public Converter<ResponseBody, ?> responseBodyConverter(Type type, Annotation[] annotations,
                                                            Retrofit retrofit) {
        TypeAdapter<?> adapter = gson.getAdapter(TypeToken.get(type));
        return new DataResponseBodyConverter<>(gson, type);
    }

    @Nullable
    @Override
    public Converter<?, RequestBody> requestBodyConverter(Type type,
                                                          Annotation[] parameterAnnotations,
                                                          Annotation[] methodAnnotations,
                                                          Retrofit retrofit) {
        TypeToken<?> token = TypeToken.get(type);
        if (!HashMap.class.isAssignableFrom(token.getRawType())) {
            return null;
        }
        return new DataRequestBodyConverter(gson);
    }
}


