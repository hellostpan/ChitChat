package com.stpan.chitchat.utils;

import android.content.Context;

import com.afollestad.materialdialogs.MaterialDialog;
import com.stpan.chitchat.R;

/**
 * 功能：
 * 创建时间:2016/4/29 22:29
 * 作者:pst
 */
public class DialogUtil {
    public static MaterialDialog dataGetDialog(Context context){
        return new MaterialDialog.Builder(context)
                .title(context.getString(R.string.dialog_title))
                .content(context.getString(R.string.dialog_message1))
                .progress(true, 0).build();
    };
    public static MaterialDialog dataHandlerDialog(Context context){
        return new MaterialDialog.Builder(context)
                .title(context.getString(R.string.dialog_title))
                .content(context.getString(R.string.dialog_message2))
                .progress(true, 0).build();
    };
    public static MaterialDialog getDialog(Context context, String content){
        return new MaterialDialog.Builder(context)
                .title(context.getString(R.string.dialog_title))
                .content(content)
                .progress(true, 0).build();
    };

    public static MaterialDialog getDialog(Context context, String title, String content){
        return new MaterialDialog.Builder(context)
                .title(title)
                .content(content)
                .progress(true, 0).build();
    };
}
