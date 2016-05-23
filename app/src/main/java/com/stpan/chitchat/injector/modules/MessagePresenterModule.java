package com.stpan.chitchat.injector.modules;

import com.stpan.chitchat.ui.Contracts.MessageContract;
import com.stpan.chitchat.ui.fragment.MessageFragment;

import dagger.Module;
import dagger.Provides;

/**
 * 功能：
 * 创建时间:2016/4/20 21:21
 * 作者:pst
 */
@Module
public class MessagePresenterModule {
    private final MessageFragment messageFragment;

    public MessagePresenterModule(MessageFragment messageFragment) {
        this.messageFragment = messageFragment;
    }

    @Provides
    MessageContract.View provideMessageContractView(){
        return messageFragment;
    }

}
