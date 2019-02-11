package com.gray.basemvp.base;

import com.gray.basemvp.http.HttpInterfaces;
import com.gray.basemvp.http.HttpUtils;

/**
 * @author wjy on 2018/3/16.
 */

public abstract class BaseMVPModel {
    protected HttpInterfaces getInterfaces() {
        return HttpUtils.getInstance().getHttpInterfaces();
    }


}
