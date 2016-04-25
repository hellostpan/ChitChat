package com.stpan.chitchat.activity.presenters;


import android.app.Activity;

import com.stpan.chitchat.activity.MainActivity;
import com.stpan.chitchat.entity.People;
import com.stpan.chitchat.entity.Student;

import javax.inject.Inject;
import javax.inject.Singleton;

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
