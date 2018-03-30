package com.gray.basemvp.utils;

import android.util.Log;

import com.gray.basemvp.base.IClassTAG;

/**
 * @author wjy on 2018/3/27.
 */

public class LogUtils {
    private static boolean isDebug;

    public static void startDebug(boolean isDebug) {
        LogUtils.isDebug = isDebug;
    }

    public static void e(IClassTAG tag, String msg) {
        e(tag.getTagName(), msg);
    }

    public static void e(String tag, String msg) {
        if (isDebug) {
            Log.e(tag, msg);
        }
    }

    public static void d(IClassTAG tag, String msg) {
        d(tag.getTagName(), msg);
    }

    public static void d(String tag, String msg) {
        if (isDebug) {
            Log.d(tag, msg);
        }
    }

    public static void i(IClassTAG tag, String msg) {
        d(tag.getTagName(), msg);
    }

    public static void i(String tag, String msg) {
        if (isDebug) {
            Log.i(tag, msg);
        }
    }
}
