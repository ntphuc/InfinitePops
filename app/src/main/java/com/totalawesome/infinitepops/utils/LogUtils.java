package com.totalawesome.infinitepops.utils;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

public class LogUtils {
    public final static boolean IS_SHOW_LOG =true;
    public final static String TAG_HOME_FEED = "home_feed";
    public static void i(String logTag, String mes) {
        if (IS_SHOW_LOG)
            Log.i(logTag, mes);
    }

    public static void showToast(Context applicationContext, String s) {
        Toast.makeText(applicationContext,s, Toast.LENGTH_LONG).show();
    }
}
