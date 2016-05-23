package com.stpan.chitchat.ui.adapter.baseAdapter;

import android.content.Context;


import java.util.List;

/**
 * 功能：
 * 创建时间:2016/1/25 15:17
 * 作者:pst
 */
public class RecyclerViewAdapter extends BaseRecyclerViewAdapter<String> {


    public RecyclerViewAdapter(Context context, List<String> list, int itemLayoutId) {
        super(context, list, itemLayoutId);
    }

    @Override
    public void convert(RecyclerViewHolder holder, String item) {

    }
}
