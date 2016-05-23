package com.stpan.chitchat.ui.presenters;

import com.stpan.chitchat.services.restApi.RestUserService;
import com.stpan.chitchat.ui.Contracts.LoginContract;
import com.stpan.chitchat.utils.Constants;
import com.stpan.chitchat.utils.RSAUtil;

import java.util.HashMap;

import javax.inject.Inject;

import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * 功能：
 * 创建时间:2016/4/26 22:26
 * 作者:pst
 */
public class LoginPresenter implements LoginContract.presenter {
    private LoginContract.view loginView;
    private RestUserService restUserService;

    @Inject
    public LoginPresenter(LoginContract.view loginView,RestUserService restUserService) {
        this.loginView = loginView;
        this.restUserService = restUserService;
    }

    @Override
    public void login(String username, String password) {
        HashMap<String,String> hashMap = new HashMap<>();
        try {
            byte[] usernames = RSAUtil.encrypt(username.getBytes(), Constants.publicKey, true);
            byte[] passwords = RSAUtil.encrypt(password.getBytes(), Constants.publicKey, true);
        } catch (Exception e) {
            e.printStackTrace();
        }
        hashMap.put("account",username);
        hashMap.put("password",password);
        restUserService.getUser(hashMap)
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
