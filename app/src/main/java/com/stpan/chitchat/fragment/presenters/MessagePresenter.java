package com.stpan.chitchat.fragment.presenters;

import com.stpan.chitchat.fragment.Contracts.MessageContract;

import javax.inject.Inject;

/**
 * 功能：
 * 创建时间:2016/4/20 21:09
 * 作者:pst
 */
public class MessagePresenter implements MessageContract.Presenter {
    private final MessageContract.View messageView;

    @Inject
    public MessagePresenter(MessageContract.View messageView) {
        this.messageView = messageView;
    }

    @Override
    public void testPresenter() {
        System.out.println("MessagePresenter: testPresenter");
    }
}
