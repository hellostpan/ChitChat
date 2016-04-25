package com.stpan.chitchat.activity;

import android.support.annotation.LayoutRes;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.ViewGroup;

import com.stpan.chitchat.MyApplication;
import com.stpan.chitchat.R;
import com.stpan.chitchat.injector.components.ChitChatApplicationComponent;

/**
 * 功能：
 * 创建时间:2016/4/12 20:24
 * 作者:pst
 */
public class BaseActivity extends AppCompatActivity {
    protected Toolbar toolbar;
    @Override
    public void setContentView(@LayoutRes int layoutResID) {
        super.setContentView(layoutResID);
        initToolbar();
    }

    @Override
    public void setContentView(View view) {
        super.setContentView(view);
        initToolbar();
    }

    @Override
    public void setContentView(View view, ViewGroup.LayoutParams params) {
        super.setContentView(view, params);
        initToolbar();
    }

    protected void initToolbar() {
        View view = findViewById(R.id.toolbar);
        if (view != null) {
            toolbar = (Toolbar) view;
            setSupportActionBar(toolbar);
        }
    }

    public ChitChatApplicationComponent getApplicationComponent(){
        return ((MyApplication) getApplication()).getChitChatApplicationComponent();
    }
}
