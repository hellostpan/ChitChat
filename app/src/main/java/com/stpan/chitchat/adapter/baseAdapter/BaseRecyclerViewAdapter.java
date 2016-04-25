package com.stpan.chitchat.adapter.baseAdapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import java.util.List;

/**
 * 功能：recyclerView的通用adapter
 * 创建时间:2016/1/25 17:37
 * 作者:pst
 */
public abstract class BaseRecyclerViewAdapter<T> extends RecyclerView.Adapter<RecyclerViewHolder> {

    protected Context context;
    protected List<T> list;
    protected int itemLayoutId;
    private OnItemClickListener onItemClickListener;
    private OnItemLongClickListener onItemLongClickListener;
    public BaseRecyclerViewAdapter(Context context, List<T> list, int itemLayoutId) {
        this.context = context;
        this.list = list;
        this.itemLayoutId = itemLayoutId;
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener){
        this.onItemClickListener = onItemClickListener;
    }

    public void setOnItemLongClickListener(OnItemLongClickListener onItemLongClickListener){
        this.onItemLongClickListener = onItemLongClickListener;
    }

    @Override
    public RecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(itemLayoutId,parent,false);
        return new RecyclerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final RecyclerViewHolder holder, int position) {
        convert(holder,list.get(position));
        //为item添加click事件
        if (onItemClickListener!=null){
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int pos = holder.getLayoutPosition();
                    onItemClickListener.onItemClick(v,pos);
                }
            });
        }
        //为item添加longClick事件
        if (onItemLongClickListener!=null){
            holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    int pos = holder.getAdapterPosition();
                    onItemLongClickListener.onItemLongClick(v,pos);
                    return true;//返回true则不会触发onclick事件，false则会接着触发onclick事件
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return list==null?0:list.size();
    }

    public abstract void convert(RecyclerViewHolder holder, T item);
}
