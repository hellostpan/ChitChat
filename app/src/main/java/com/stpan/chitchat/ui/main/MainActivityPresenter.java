package com.stpan.chitchat.ui.main;


import javax.inject.Inject;

/**
 * 功能：
 * 创建时间:2016/3/15 : 16:03
 * 作者:pst
 */
public class MainActivityPresenter {
    private MainActivity mainActivity;

    @Inject
    public MainActivityPresenter(MainActivity mainActivity) {
        this.mainActivity = mainActivity;
    }



}
