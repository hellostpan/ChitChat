package com.stpan.chitchat.activity.presenters;

import com.stpan.chitchat.activity.Contracts.LoginContract;
import com.stpan.chitchat.utils.Constants;

import javax.inject.Inject;

/**
 * 功能：
 * 创建时间:2016/4/26 22:26
 * 作者:pst
 */
public class LoginPresenter implements LoginContract.presenter {
    private LoginContract.view loginView;

    @Inject
    public LoginPresenter(LoginContract.view loginView) {
        this.loginView = loginView;
    }
}
