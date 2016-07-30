package com.stpan.chitchat.utils;

import android.app.Activity;
import android.content.Context;
import android.util.DisplayMetrics;

/**
 * 功能：
 * 创建时间:2016/7/22 : 8:57
 * 作者:pst
 * 版权: sowell
 */
public class ScreenUtil {

    public static int getScreenHeight(Activity activity){
        DisplayMetrics displayMetrics = getDisplayMetrics(activity);
        return displayMetrics.heightPixels;
    }

    public static int getScreenWidth(Activity activity){
        DisplayMetrics displayMetrics = getDisplayMetrics(activity);
        return displayMetrics.widthPixels;
    }

    public static int dip2px(Context context, float dipValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dipValue * scale + 0.5f);
    }

    public static int px2dip(Context context, float pxValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (pxValue / scale + 0.5f);
    }

    private static DisplayMetrics getDisplayMetrics(Activity activity){
        DisplayMetrics displayMetrics = activity.getApplicationContext().getResources().getDisplayMetrics();
        activity.getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        return displayMetrics;
    }
}
