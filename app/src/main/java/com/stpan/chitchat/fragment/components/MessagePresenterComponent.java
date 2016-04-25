package com.stpan.chitchat.fragment.components;

import com.stpan.chitchat.MyApplication;
import com.stpan.chitchat.fragment.Contracts.MessageContract;
import com.stpan.chitchat.fragment.MessageFragment;
import com.stpan.chitchat.fragment.modules.MessagePresenterModule;
import com.stpan.chitchat.fragment.presenters.MessagePresenter;
import com.stpan.chitchat.injector.PerFragment;
import com.stpan.chitchat.injector.components.ChitChatApplicationComponent;
import com.stpan.chitchat.services.restApi.RestService;

import javax.inject.Singleton;

import dagger.Component;

/**
 * 功能：
 * 创建时间:2016/4/20 21:18
 * 作者:pst
 */
@PerFragment
@Component(dependencies = ChitChatApplicationComponent.class,modules = MessagePresenterModule.class)
public interface MessagePresenterComponent {
    MessageContract.View getMessageContractView();
    void inject(MessageFragment messageFragment);
}
