package com.stpan.chitchat.ui.presenters;

import com.stpan.chitchat.ui.Contracts.MessageContract;
import com.stpan.chitchat.services.restApi.RestUserService;

import javax.inject.Inject;

/**
 * 功能：
 * 创建时间:2016/4/20 21:09
 * 作者:pst
 */
public class MessagePresenter implements MessageContract.Presenter {
    private final MessageContract.View messageView;
    private RestUserService restUserService;

    @Inject
    public MessagePresenter(MessageContract.View messageView,RestUserService restUserService) {
        this.messageView = messageView;
        this.restUserService = restUserService;
    }

}
