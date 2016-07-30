package com.stpan.chitchat.ui.main;

import com.stpan.chitchat.services.UserService;

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
    MessageContract.View provideMessageView(){
        return messageFragment;
    }

    @Provides
    MessageContract.Presenter provideMessagePresent(UserService userService){
        return new MessagePresenter(messageFragment,userService);
    }

}
