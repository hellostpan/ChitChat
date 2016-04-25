package com.stpan.chitchat.injector.modules;

import android.app.Application;
import android.content.Context;
import android.location.LocationManager;

import com.google.gson.Gson;
import com.stpan.chitchat.MyApplication;
import com.stpan.chitchat.injector.PerApp;
import com.stpan.chitchat.services.restApi.RestService;
import com.stpan.chitchat.services.restApi.RetrofitServices;
import com.stpan.chitchat.utils.GsonUtil;

import static android.content.Context.LOCATION_SERVICE;

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
    RestService provideRestService(){
        return RetrofitServices.getInstance().getRestService();
    }

    @Provides @Singleton
    Gson provideGson(){
        return new Gson();
    }
}
