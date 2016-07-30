package com.stpan.chitchat.ui.main;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * 功能：
 * 创建时间:2016/4/16 17:20
 * 作者:pst
 */
public class MainAdapter extends FragmentPagerAdapter {
    List<Fragment> list;

    public MainAdapter(FragmentManager fm,List<Fragment> list) {
        super(fm);
        this.list = list;
    }

    @Override
    public int getCount() {
        return list == null ? 0 : list.size();
    }

    @Override
    public Fragment getItem(int position) {
        return list.get(position);
    }

    @Override
    public int getItemPosition(Object object) {
        return POSITION_NONE;
    }
}
