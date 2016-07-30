package com.stpan.chitchat.ui.login;

/**
 * 功能：
 * 创建时间:2016/4/26 22:21
 * 作者:pst
 */
public interface LoginContract {
    interface view{
        void loginResult(String result);
        void showDialog();
        void dismissDialog();
    }

    interface presenter{
        void login(String username,String password);
    }
}
