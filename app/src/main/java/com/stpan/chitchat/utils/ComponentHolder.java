package com.stpan.chitchat.utils;


import com.stpan.chitchat.injector.components.ChitChatApplicationComponent;

/**
 * 功能：
 * 创建时间:2016/7/19 : 9:13
 * 作者:pst
 * 版权: sowell
 */
public class ComponentHolder {
    private static ChitChatApplicationComponent chitChatApplicationComponent;

    public static ChitChatApplicationComponent getApplicationComponent() {
        return chitChatApplicationComponent;
    }

    public static void setApplicationComponent(ChitChatApplicationComponent applicationComponent) {
        chitChatApplicationComponent = applicationComponent;
    }
}
