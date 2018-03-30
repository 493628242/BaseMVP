package com.gray.basemvp.error;

import static com.gray.basemvp.error.ErrorMsg.ERROR_EXCEPTION;

/**
 * @author wjy on 2018/3/23.
 */

public class ErrorManager {
    private static ErrorManager manager;

    private ErrorManager() {
    }

    public static ErrorManager getInstance() {
        if (manager == null) {
            synchronized (ErrorManager.class) {
                manager = new ErrorManager();
            }
        }
        return manager;
    }

    public String getMsg(int code) {
        for (ErrorMsg errorMsg : ErrorMsg.values()) {
            if (errorMsg.getCode() == code) {
                return errorMsg.getMsg();
            }
        }
        return ERROR_EXCEPTION.getMsg();
    }

    public String getCommonMsg() {
        return ERROR_EXCEPTION.getMsg();
    }


}
