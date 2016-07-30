package com.stpan.chitchat.ui.main;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.stpan.chitchat.R;
import com.stpan.chitchat.utils.ComponentHolder;

import javax.inject.Inject;

public class MessageFragment extends Fragment implements MessageContract.View{
    @Inject
    MessageContract.Presenter messagePresenter;

    public static MessageFragment newInstance() {
        MessageFragment fragment = new MessageFragment();
        return fragment;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        DaggerMessageComponent.builder()
                .chitChatApplicationComponent(ComponentHolder.getApplicationComponent())
                .messagePresenterModule(new MessagePresenterModule(this))
                .build().injectMessageFragment(this);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_message, container, false);
    }

}
