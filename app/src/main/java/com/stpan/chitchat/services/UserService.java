package com.stpan.chitchat.services;

import com.stpan.chitchat.services.restApi.ResultEntity;

import java.util.HashMap;

import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
import rx.Observable;

/**
 * Created by hasee on 2016/1/26.
 */
public interface UserService {

    @POST("rest/user/login")
    Observable<ResultEntity<HashMap<String,String>>> getUser(@Body HashMap<String,String> hashMap);

    @FormUrlEncoded
    @POST("user")
    Observable<ResultEntity<HashMap<String,String>>> getUserPost(@Field(value = "name") String name);
}
