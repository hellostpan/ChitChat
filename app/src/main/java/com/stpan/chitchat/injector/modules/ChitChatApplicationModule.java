package com.stpan.chitchat.injector.modules;

import com.google.gson.Gson;
import com.stpan.chitchat.MyApplication;
import com.stpan.chitchat.services.restApi.RestUserService;
import com.stpan.chitchat.services.restApi.RetrofitServices;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * 功能：
 * 创建时间:2016/4/9 13:38
 * 作者:pst
 */
@Module
public class ChitChatApplicationModule{
    private final MyApplication application;

    public ChitChatApplicationModule(MyApplication application) {
        this.application = application;
    }

    @Provides
    @Singleton
    MyApplication provideApplication() {
        return application;
    }

    @Provides
    @Singleton
    RestUserService provideRestService(){
        return RetrofitServices.getInstance().getRestUserService();
    }

    @Provides @Singleton
    Gson provideGson(){
        return new Gson();
    }
}
