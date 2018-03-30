package com.gray.basemvp.error;

/**
 * @author wjy on 2018/3/27.
 */

public class NetResponseException extends RuntimeException {
    //对应ErrorMsg里的code
    private int code;

    public NetResponseException(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }
}
