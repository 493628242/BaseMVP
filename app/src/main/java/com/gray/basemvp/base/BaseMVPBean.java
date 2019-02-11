package com.gray.basemvp.base;

import com.google.gson.annotations.SerializedName;

/**
 * @author wjy on 2018/3/16.
 *         需要根据项目需要进行修改
 */

public abstract class BaseMVPBean {
    //服务器传来的错误code
    @SerializedName("api_msg")
    private String code;
    @SerializedName("api_code")
    private int apiCode;

    public int getApiCode() {
        return apiCode;
    }

    public void setApiCode(int apiCode) {
        this.apiCode = apiCode;
    }

    public String getApiMsg() {
        return code;
    }

    public void setApiMsg(String code) {
        this.code = code;
    }
}
