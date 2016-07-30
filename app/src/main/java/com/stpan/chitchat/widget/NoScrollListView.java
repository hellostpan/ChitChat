package com.stpan.chitchat.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ListView;

/**
 * 功能：解决在ScrollerView嵌套下导致显示不全的问题,直接显示所有的，不可在其他地方使用。
 * 创建时间:15/1/14 14:28
 * 作者:zbd
 * 版权: sowell,onegcloud
 */
public class NoScrollListView extends ListView {
    private static final String TAG = "NoScrollListView";

    public NoScrollListView(Context context) {
        super(context);
    }

    public NoScrollListView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public NoScrollListView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int expandSpec = MeasureSpec.makeMeasureSpec(Integer.MAX_VALUE >> 2, MeasureSpec.AT_MOST);
        super.onMeasure(widthMeasureSpec, expandSpec);
    }
}
