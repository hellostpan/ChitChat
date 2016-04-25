package com.stpan.chitchat.fragment.modules;

import com.stpan.chitchat.fragment.Contracts.MessageContract;
import com.stpan.chitchat.fragment.MessageFragment;
import com.stpan.chitchat.services.restApi.RestService;
import com.stpan.chitchat.services.restApi.RetrofitServices;

import javax.inject.Singleton;

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

    @Provides
    RestService provideRestService(){
        return RetrofitServices.getInstance().getRestService();
    }
}
