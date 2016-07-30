package com.stpan.chitchat.injector.modules;

import com.stpan.chitchat.MyApplication;
import com.stpan.chitchat.R;
import com.stpan.chitchat.services.UserService;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

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
    UserService provideUserService(Retrofit retrofit){
        return retrofit.create(UserService.class);
    }

    @Provides
    @Singleton
    Retrofit provideRetrofit(MyApplication application) {
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        return new Retrofit.Builder()
                .baseUrl(application.getString(R.string.rest_url))
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .client(new OkHttpClient.Builder()
                        //.addNetworkInterceptor(new LoggingInterceptor())
                        .addInterceptor(interceptor)
                        .build())
                .build();
    }
}
