package com.gray.basemvp.utils;

import android.widget.Toast;

import com.gray.basemvp.base.BaseApplication;

/**
 * @author wjy on 2018/10/15/015.
 * 单例Toast 避免Toast多次出现
 */
public class SingleToast {
    private static Toast toast;

    private SingleToast() {
    }

    private static void showToast(String info, int duration) {
        if (toast == null) {
            synchronized (SingleToast.class) {
                if (toast == null) {
                    toast = new Toast(BaseApplication.APP);
                }
            }
        }
        toast.setDuration(duration);
        toast.setText(info);
        toast.show();
    }

    /**
     * 显示短Toast
     *
     * @param info 信息
     */
    public static void showShortToast(String info) {
        showToast(info, Toast.LENGTH_SHORT);
    }

    /**
     * 显示长Toast
     *
     * @param info 信息
     */
    public static void showLongToast(String info) {
        showToast(info, Toast.LENGTH_LONG);
    }
}
