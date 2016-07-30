package com.stpan.chitchat.ui.main;

import android.content.Context;

import com.stpan.chitchat.R;
import com.stpan.chitchat.adapter.baseAdapter.BaseRecyclerViewAdapter;
import com.stpan.chitchat.adapter.baseAdapter.RecyclerViewHolder;

import java.util.HashMap;
import java.util.List;

/**
 * 功能：
 * 创建时间:2016/5/5 22:05
 * 作者:pst
 */
public class MessageAdapter extends BaseRecyclerViewAdapter<HashMap<String,String>> {
    public MessageAdapter(Context context, List<HashMap<String, String>> list) {
        super(context, list, R.layout.adapter_message);
    }

    @Override
    public void convert(RecyclerViewHolder holder, HashMap<String, String> item) {

    }
}
