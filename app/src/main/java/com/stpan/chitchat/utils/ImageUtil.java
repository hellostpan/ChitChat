package com.stpan.chitchat.utils;

import android.content.Context;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;
import com.stpan.chitchat.R;

/**
 * 功能：
 * 创建时间:2016/7/20 : 14:07
 * 作者:pst
 * 版权: sowell
 */
public class ImageUtil {

    public static void setImageOfPath(Context context, String path, ImageView imageView){
        Picasso.with(context)
                .load(path)
                .placeholder(R.mipmap.headimg_gril)
                .error(R.mipmap.headimg_gril)
                .into(imageView);
    }
    public static void setImageOfPath(Context context, String path,int placeHolder,int error, ImageView imageView){
        Picasso.with(context)
                .load(path)
                .placeholder(placeHolder)
                .error(error)
                .into(imageView);
    }
    public static void setImageOfResId(Context context, int resourceId, ImageView imageView){
        Picasso.with(context)
                .load(resourceId)
                .into(imageView);
    }

    public static void setHeadImage(Context context, String path, ImageView imageView){
        Picasso.with(context)
                .load(path)
                .placeholder(R.mipmap.headimg_gril)
                .error(R.mipmap.headimg_gril)
                .into(imageView);
    }
}
