package com.stpan.chitchat.ui.main;

import com.stpan.chitchat.injector.PerFragment;
import com.stpan.chitchat.injector.components.ChitChatApplicationComponent;

import dagger.Component;

/**
 * 功能：
 * 创建时间:2016/4/20 21:18
 * 作者:pst
 */
@PerFragment
@Component(dependencies = ChitChatApplicationComponent.class,modules = MessagePresenterModule.class)
public interface MessageComponent {
    void injectMessageFragment(MessageFragment messageFragment);
}
