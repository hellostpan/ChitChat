package com.stpan.chitchat.ui.login;

import com.stpan.chitchat.MyApplication;
import com.stpan.chitchat.services.UserService;

import java.util.HashMap;

import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * 功能：
 * 创建时间:2016/4/26 22:26
 * 作者:pst
 */
public class LoginPresenter implements LoginContract.presenter {
    private LoginContract.view loginView;
    private UserService userService;
    private MyApplication myApplication;

    public LoginPresenter(LoginContract.view loginView, UserService userService, MyApplication myApplication) {
        this.loginView = loginView;
        this.userService = userService;
        this.myApplication = myApplication;
    }

    @Override
    public void login(String username, String password) {
        HashMap<String,String> hashMap = new HashMap<>();
        hashMap.put("account",username);
        hashMap.put("password",password);
        userService.getUser(hashMap)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .doOnSubscribe(() -> loginView.showDialog())
                .doOnUnsubscribe(() -> loginView.dismissDialog())
                .subscribe(hashMapResultEntity -> {
                    if ("1".equals(hashMapResultEntity.getCode())){
                        loginView.loginResult("success");
                    }else {
                        loginView.loginResult("failed");
                    }
                },Throwable::printStackTrace);
    }
}
