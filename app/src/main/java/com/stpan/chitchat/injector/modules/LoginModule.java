package com.stpan.chitchat.injector.modules;

import com.stpan.chitchat.ui.Contracts.LoginContract;
import com.stpan.chitchat.ui.activity.LoginActivity;

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
