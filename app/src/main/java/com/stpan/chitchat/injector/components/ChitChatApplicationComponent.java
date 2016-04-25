package com.stpan.chitchat.injector.components;

import android.app.Application;
import android.location.LocationManager;

import com.stpan.chitchat.MyApplication;
import com.stpan.chitchat.injector.PerApp;
import com.stpan.chitchat.injector.modules.ChitChatApplicationModule;

import javax.inject.Singleton;

import dagger.Component;

/**
 * 功能：
 * 创建时间:2016/4/9 13:41
 * 作者:pst
 */
@Singleton
@Component(modules = ChitChatApplicationModule.class)
public interface ChitChatApplicationComponent {
    MyApplication getMyApplication();
}
