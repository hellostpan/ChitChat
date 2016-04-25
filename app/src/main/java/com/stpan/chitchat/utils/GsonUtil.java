package com.stpan.chitchat.utils;

import com.google.gson.Gson;

/**
 * 功能：
 * 创建时间:2016/4/12 20:18
 * 作者:pst
 */
public class GsonUtil {
    private static Gson gson = new Gson();

    public static Gson getGson(){
        return gson;
    }
}
