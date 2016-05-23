package com.stpan.chitchat.ui.adapter.baseAdapter;

import android.support.v7.widget.RecyclerView;
import android.util.SparseArray;
import android.view.View;
import android.widget.TextView;

/**
 * 功能：
 * 创建时间:2016/1/25 17:39
 * 作者:pst
 * 版权: sowell,onegcloud
 */
public class RecyclerViewHolder extends RecyclerView.ViewHolder {
    private SparseArray<View> array;
    public RecyclerViewHolder(View itemView) {
        super(itemView);
        array = new SparseArray<>();
    }

    public <T extends View> T getView(int id){
        if (array.get(id)==null){
            array.put(id,itemView.findViewById(id));
        }
        return (T) array.get(id);
    }

    public RecyclerViewHolder setText(int id, String content){
        TextView textView = getView(id);
        textView.setText(content);
        return this;
    }
}
