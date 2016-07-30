package com.stpan.chitchat.ui.login;

import com.stpan.chitchat.MyApplication;
import com.stpan.chitchat.services.UserService;

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

    @Provides
    public LoginContract.presenter provideLoginContractPresent(LoginContract.view loginView, UserService userService, MyApplication myApplication){
        return new LoginPresenter(loginView, userService,myApplication);
    }
}
