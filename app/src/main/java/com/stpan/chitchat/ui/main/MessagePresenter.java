package com.stpan.chitchat.ui.main;

import com.stpan.chitchat.services.UserService;

/**
 * 功能：
 * 创建时间:2016/4/20 21:09
 * 作者:pst
 */
public class MessagePresenter implements MessageContract.Presenter {
    private final MessageContract.View messageView;
    private UserService userService;


    public MessagePresenter(MessageContract.View messageView,UserService userService) {
        this.messageView = messageView;
        this.userService = userService;
    }

}
