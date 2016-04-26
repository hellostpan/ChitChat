package com.stpan.chitchat.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.stpan.chitchat.MyApplication;
import com.stpan.chitchat.R;
import com.stpan.chitchat.activity.Contracts.LoginContract;
import com.stpan.chitchat.activity.components.DaggerLoginComponent;
import com.stpan.chitchat.activity.modules.LoginModule;
import com.stpan.chitchat.activity.presenters.LoginPresenter;
import com.stpan.chitchat.injector.components.ChitChatApplicationComponent;

import javax.inject.Inject;

import butterknife.ButterKnife;

public class LoginActivity extends AppCompatActivity implements LoginContract.view{
    @Inject
    LoginPresenter loginPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        init();
    }

    private void init(){
        ButterKnife.bind(this);
        ChitChatApplicationComponent component = MyApplication.getInstance().getChitChatApplicationComponent();
        DaggerLoginComponent.builder()
                .chitChatApplicationComponent(component)
                .loginModule(new LoginModule(this))
                .build().inject(this);
        System.out.println(loginPresenter==null);
    }
}
