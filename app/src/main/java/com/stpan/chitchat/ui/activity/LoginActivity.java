package com.stpan.chitchat.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;

import com.afollestad.materialdialogs.MaterialDialog;
import com.stpan.chitchat.MyApplication;
import com.stpan.chitchat.R;
import com.stpan.chitchat.injector.components.ChitChatApplicationComponent;
import com.stpan.chitchat.injector.components.DaggerLoginComponent;
import com.stpan.chitchat.injector.modules.LoginModule;
import com.stpan.chitchat.ui.Contracts.LoginContract;
import com.stpan.chitchat.utils.ToastUtil;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LoginActivity extends AppCompatActivity implements LoginContract.view {
    @Bind(R.id.et_act_login_username)
    EditText etUsername;
    @Bind(R.id.et_act_login_password)
    EditText etPassword;

    private LoginContract.presenter loginPresenter;
    private MaterialDialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
        init();
    }

    private void init() {
        ButterKnife.bind(this);
        ChitChatApplicationComponent component = MyApplication.getInstance().getChitChatApplicationComponent();
        loginPresenter = DaggerLoginComponent.builder()
                .chitChatApplicationComponent(component)
                .loginModule(new LoginModule(this))
                .build().getLoginPresenter();
        dialog = new MaterialDialog.Builder(this)
                .title("请稍等")
                .content("正在登录...")
                .progress(true, 0)
                .build();
    }

    @OnClick(R.id.tv_act_login_submit)
    public void onClick() {
        String username = etUsername.getText().toString().trim();
        String password = etPassword.getText().toString().trim();
        loginPresenter.login(username, password);
    }

    @Override
    public void loginResult(String result) {
        if ("success".equals(result)){
            startActivity(new Intent(this,MainActivity.class));
        }else {
            ToastUtil.showToast(this,"用户名或密码错误！");
        }
    }

    @Override
    public void showDialog() {
        dialog.show();
    }

    @Override
    public void dismissDialog() {
        dialog.dismiss();
    }
}
