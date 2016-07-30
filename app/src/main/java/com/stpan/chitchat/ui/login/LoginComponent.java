package com.stpan.chitchat.ui.login;

import com.stpan.chitchat.injector.components.ChitChatApplicationComponent;
import com.stpan.chitchat.injector.PerActivity;

import dagger.Component;

/**
 * 功能：
 * 创建时间:2016/4/26 22:24
 * 作者:pst
 */
@PerActivity
@Component(dependencies = ChitChatApplicationComponent.class,modules = LoginModule.class)
public interface LoginComponent {
    void injectLoginActivity(LoginActivity activity);
}
