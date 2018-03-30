package com.gray.basemvp.error;

/**
 * @author wjy on 2018/3/27.
 */

public enum ErrorMsg {
    ERROR_NET("网络请求失败", 100),
    ERROR_TOKEN_INVALID("账号过期", 500),
    ERROR_BEAN_ILLEGAL("Bean对象应当继承BaseBean", 400),
    ERROR_EXCEPTION("未知错误", 300);
    private String msg;
    private int code;

    ErrorMsg(String msg, int code) {
        this.msg = msg;
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }


    public int getCode() {
        return code;
    }

}
