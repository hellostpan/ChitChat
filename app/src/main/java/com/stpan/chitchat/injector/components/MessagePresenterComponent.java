package com.stpan.chitchat.injector.components;

import com.stpan.chitchat.ui.presenters.MessagePresenter;
import com.stpan.chitchat.injector.modules.MessagePresenterModule;
import com.stpan.chitchat.injector.PerFragment;

import dagger.Component;

/**
 * 功能：
 * 创建时间:2016/4/20 21:18
 * 作者:pst
 */
@PerFragment
@Component(dependencies = ChitChatApplicationComponent.class,modules = MessagePresenterModule.class)
public interface MessagePresenterComponent {
    MessagePresenter getMessagePresent();
}
