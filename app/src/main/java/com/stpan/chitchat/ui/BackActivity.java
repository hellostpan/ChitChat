package com.stpan.chitchat.ui;

import android.view.MenuItem;

import com.stpan.chitchat.R;

/**
 * 功能：
 * 创建时间:2016/4/12 20:37
 * 作者:pst
 */
public class BackActivity extends BaseActivity {

    @Override
    protected void initToolbar() {
        super.initToolbar();
        if (toolbar!=null){
            toolbar.setNavigationIcon(R.drawable.ic_arrow_back_24dp);
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId()==android.R.id.home){
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
