package com.stpan.chitchat.injector.modules;

import android.location.LocationManager;

import com.google.gson.Gson;
import com.stpan.chitchat.MyApplication;
import com.stpan.chitchat.services.restApi.RestService;
import com.stpan.chitchat.services.restApi.RetrofitServices;
import com.stpan.chitchat.utils.GsonUtil;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

import static android.content.Context.LOCATION_SERVICE;

/**
 * 功能：
 * 创建时间:2016/4/12 20:11
 * 作者:pst
 */
@Module
public class BaseModule {
    @Provides
    MyApplication provideApplication() {
        return MyApplication.getInstance();
    }

    @Provides
    RestService provideRestService(){
        return RetrofitServices.getInstance().getRestService();
    }

    @Provides
    Gson provideGson(){
        return GsonUtil.getGson();
    }
}
