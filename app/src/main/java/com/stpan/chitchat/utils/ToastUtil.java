package com.stpan.chitchat.utils;

import android.content.Context;
import android.widget.Toast;

/**
 * 功能：
 * 创建时间:2016/4/27 21:44
 * 作者:pst
 */
public class ToastUtil {

    public static void showToast(Context context,String content){
        Toast.makeText(context,content,Toast.LENGTH_SHORT).show();
    }
}
