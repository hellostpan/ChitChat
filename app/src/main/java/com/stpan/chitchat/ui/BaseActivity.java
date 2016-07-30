package com.stpan.chitchat.ui;

import android.support.annotation.LayoutRes;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.stpan.chitchat.R;

/**
 * 功能：
 * 创建时间:2016/4/12 20:24
 * 作者:pst
 */
public class BaseActivity extends AppCompatActivity {
    protected Toolbar toolbar;
    private TextView textViewTitle;
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

    @Override
    protected void onTitleChanged(CharSequence title, int color) {
        super.onTitleChanged(title, color);
        if (textViewTitle!=null){
            textViewTitle.setText(title);
        }
    }

    protected void initToolbar() {
        View view = findViewById(R.id.toolbar);
        if (view != null) {
            toolbar = (Toolbar) view;
            setSupportActionBar(toolbar);
            textViewTitle = (TextView) toolbar.findViewById(R.id.tv_custom_toolbar_title);
            if (textViewTitle!=null&&getSupportActionBar()!=null){
                getSupportActionBar().setDisplayShowTitleEnabled(false);
            }
        }
    }
}
