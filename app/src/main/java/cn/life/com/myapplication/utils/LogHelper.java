package cn.life.com.myapplication.utils;

import android.util.Log;

/**
 * Created by wanglikun on 2018/9/10.
 */

public class LogHelper {
    private static final boolean DEBUG = true;
    private static final String TAG = "Doraemon";

    public static void d(String subTag, String msg) {
        if (DEBUG) {
            Log.d(TAG, "[" + subTag + "]: " + msg);
        }
    }

    public static void i(String subTag, String msg) {
        if (DEBUG) {
            Log.i(TAG, "[" + subTag + "]: " + msg);
        }
    }

    public static void e(String subTag, String msg) {
        if (DEBUG) {
            Log.e(TAG, "[" + subTag + "]: " + msg);
        }
    }
}
