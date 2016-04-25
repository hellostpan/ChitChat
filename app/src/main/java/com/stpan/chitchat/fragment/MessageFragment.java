package com.stpan.chitchat.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.stpan.chitchat.MyApplication;
import com.stpan.chitchat.R;
import com.stpan.chitchat.activity.MainActivity;
import com.stpan.chitchat.fragment.Contracts.MessageContract;
import com.stpan.chitchat.fragment.components.DaggerMessagePresenterComponent;
import com.stpan.chitchat.fragment.modules.MessagePresenterModule;
import com.stpan.chitchat.fragment.presenters.MessagePresenter;
import com.stpan.chitchat.injector.components.ChitChatApplicationComponent;
import com.stpan.chitchat.services.restApi.RestService;

import javax.inject.Inject;

public class MessageFragment extends Fragment implements MessageContract.View{
    @Inject
    MyApplication myApplication;
    @Inject
    RestService restService;
    @Inject
    MessagePresenter messagePresenter;

    public static MessageFragment newInstance() {
        MessageFragment fragment = new MessageFragment();
        return fragment;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        ChitChatApplicationComponent applicationComponent = ((MainActivity)getActivity()).getApplicationComponent();
        DaggerMessagePresenterComponent.builder()
                .chitChatApplicationComponent(applicationComponent)
                .messagePresenterModule(new MessagePresenterModule(this))
                .build().inject(this);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_message, container, false);
    }

    @Override
    public void testView() {
        System.out.println("MessageFragment: testView");
    }
}
