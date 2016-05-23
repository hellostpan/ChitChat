package com.stpan.chitchat.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.stpan.chitchat.R;
import com.stpan.chitchat.ui.activity.MainActivity;
import com.stpan.chitchat.ui.Contracts.MessageContract;
import com.stpan.chitchat.injector.components.ChitChatApplicationComponent;
import com.stpan.chitchat.injector.components.DaggerMessagePresenterComponent;
import com.stpan.chitchat.injector.modules.MessagePresenterModule;

public class MessageFragment extends Fragment implements MessageContract.View{
    private MessageContract.Presenter messagePresenter;

    public static MessageFragment newInstance() {
        MessageFragment fragment = new MessageFragment();
        return fragment;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        ChitChatApplicationComponent applicationComponent = ((MainActivity)getActivity()).getApplicationComponent();
        messagePresenter = DaggerMessagePresenterComponent.builder()
                .chitChatApplicationComponent(applicationComponent)
                .messagePresenterModule(new MessagePresenterModule(this))
                .build().getMessagePresent();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_message, container, false);
    }

}
