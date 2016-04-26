package com.stpan.chitchat.activity.components;

import com.stpan.chitchat.activity.LoginActivity;
import com.stpan.chitchat.activity.modules.LoginModule;
import com.stpan.chitchat.injector.PerActivity;
import com.stpan.chitchat.injector.components.ChitChatApplicationComponent;

import dagger.Component;

/**
 * 功能：
 * 创建时间:2016/4/26 22:24
 * 作者:pst
 */
@PerActivity
@Component(dependencies = ChitChatApplicationComponent.class,modules = LoginModule.class)
public interface LoginComponent {
    void inject(LoginActivity loginActivity);
}
