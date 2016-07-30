package com.stpan.chitchat.injector.components;


import com.stpan.chitchat.injector.PerActivity;
import com.stpan.chitchat.ui.main.MainActivity;

import dagger.Component;

/**
 * 功能：
 * 创建时间:2016/7/19 : 8:51
 * 作者:pst
 * 版权: sowell
 */
@PerActivity
@Component(dependencies = ChitChatApplicationComponent.class)
public interface ActivityComponent {
    void injectMainActivity(MainActivity mainActivity);
}
