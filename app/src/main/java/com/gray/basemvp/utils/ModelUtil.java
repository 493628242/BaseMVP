package com.gray.basemvp.utils;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.gray.basemvp.base.BaseModel;

import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;

/**
 * @author wjy on 2018/3/17.
 */

public class ModelUtil {
    /**
     * 获取上传图片的请求体
     */
    @NonNull
    public static RequestBody getImageRequestBody(File file) {
        return getRequestBody("image", file);
    }

    /**
     * 获取上传视频的请求体
     */
    @NonNull
    public static RequestBody getVideoRequestBody(File file) {
        return getRequestBody("video", file);
    }

    /**
     * 获取上传音频的请求体
     */
    @NonNull
    public static RequestBody getAudioRequestBody(File file) {
        return getRequestBody("audio", file);
    }

    /**
     * 获取上传文件的请求体
     */
    @NonNull
    public static RequestBody getRequestBody(String type, File file) {
        String name = file.getName();
        return MultipartBody.create(MediaType.parse(type + "/" + name.lastIndexOf(".")), file);
    }

    /**
     * 获取MultipartBody
     *
     * @param map
     * @param bodys
     * @return
     */
    @NonNull
    public static RequestBody getMultiPartBody(@Nullable HashMap<String, String> map, @NonNull RequestBody... bodys) {
        MultipartBody.Builder builder = new MultipartBody.Builder()
                .setType(MultipartBody.FORM);
        if (map != null && map.size() != 0) {
            Set<String> keySet = map.keySet();
            for (String key : keySet) {
                builder.addFormDataPart(key, map.get(key));
            }
        }
        for (RequestBody body :
                bodys) {
            MediaType mediaType = body.contentType();
            String type;
            if (mediaType != null) {
                type = mediaType.type();
                builder.addFormDataPart(type, "", body);
            } else {
                builder.addPart(body);
            }
        }
        return builder.build();
    }

}
