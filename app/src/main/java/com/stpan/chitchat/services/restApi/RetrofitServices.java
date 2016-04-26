package com.stpan.chitchat.services.restApi;


import com.stpan.chitchat.utils.Constants;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by hasee on 2016/1/26.
 */
public class RetrofitServices {
    private Retrofit retrofit;
    private static RetrofitServices retrofitServices;

    public static RetrofitServices getInstance(){
        if (retrofitServices == null) {
            synchronized (RetrofitServices.class) {
                if (retrofitServices == null) {
                    retrofitServices = new RetrofitServices();
                }
            }
        }
        return retrofitServices;
    }

    private Retrofit getRetrofit() {
        if (retrofit == null) {
            synchronized (RetrofitServices.class) {
                if (retrofit == null) {
                    retrofit = new Retrofit.Builder()
                            .baseUrl(Constants.rest_path)
                            .addConverterFactory(GsonConverterFactory.create())
                            .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                            .client(new OkHttpClient.Builder()
                                    .addNetworkInterceptor(new LoggingInterceptor())
                                    .build())
                            .build();
                }
            }
        }
        return retrofit;
    }

    public RestService getRestService() {
        return getRetrofit().create(RestService.class);
    }
}
