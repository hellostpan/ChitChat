package com.stpan.chitchat.activity.modules;

import com.stpan.chitchat.activity.Contracts.LoginContract;
import com.stpan.chitchat.activity.LoginActivity;

import dagger.Module;
import dagger.Provides;

/**
 * 功能：
 * 创建时间:2016/4/26 22:21
 * 作者:pst
 */
@Module
public class LoginModule {
    private final LoginActivity loginActivity;

    public LoginModule(LoginActivity loginActivity) {
        this.loginActivity = loginActivity;
    }

    @Provides
    public LoginContract.view provideLoginContractView(){
        return loginActivity;
    }
}
