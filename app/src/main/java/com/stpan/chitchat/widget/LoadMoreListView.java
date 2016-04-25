package com.stpan.chitchat.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AbsListView;
import android.widget.LinearLayout;
import android.widget.ListView;

import com.stpan.chitchat.R;

/**
 * Created by stpan on 2016/3/15.
 */
public class LoadMoreListView extends ListView implements AbsListView.OnScrollListener {
    private LinearLayout footer;
    private int totalItemCount;
    private int lastItemCount;
    private boolean isLoading = false;
    private boolean isEnd = false;
    private IOnLoadMoreLister iOnLoadMoreLister;

    public LoadMoreListView(Context context) {
        super(context);
        initView(context);
    }

    public LoadMoreListView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView(context);
    }

    public LoadMoreListView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView(context);
    }

    /**
     * 添加底部加载提示布局到listview
     *
     * @param context
     */
    private void initView(Context context) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.footer_layout, null);
        footer = (LinearLayout) view.findViewById(R.id.load_layout);
        footer.setVisibility(GONE);
        this.addFooterView(view);
        this.setOnScrollListener(this);
    }

    @Override
    public void onScrollStateChanged(AbsListView view, int scrollState) {
        if (totalItemCount==lastItemCount&&scrollState==SCROLL_STATE_IDLE){
            if (!isLoading&&!isEnd){
                isLoading = true;
                footer.setVisibility(VISIBLE);
                iOnLoadMoreLister.loadingMore();
            }
        }
    }

    @Override
    public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
        this.totalItemCount = totalItemCount;
        this.lastItemCount = firstVisibleItem+visibleItemCount;
    }

    public void setOnLoadingMoreLister(IOnLoadMoreLister iOnLoadMoreLister){
        this.iOnLoadMoreLister = iOnLoadMoreLister;
    }

    public void loadingComplete(){
        isLoading = false;
        footer.setVisibility(GONE);
    }

    public void setIsEnd(boolean isEnd){
        this.isEnd = isEnd;
    }

    public interface IOnLoadMoreLister{
        public void loadingMore();
    }
}
