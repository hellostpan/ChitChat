package com.stpan.chitchat.widget;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.widget.TextView;

/**
 * 作者：db
 * 功能：
 * 创建时间：2016/7/27 0027 14:43
 * 版权:Sowell
 */
public class MarqueeTextView extends TextView {
    public MarqueeTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onFocusChanged(boolean focused, int direction, Rect previouslyFocusedRect) {
        super.onFocusChanged(focused, direction, previouslyFocusedRect);
    }

    @Override
    public void onWindowFocusChanged(boolean hasWindowFocus) {
        if (hasWindowFocus) super.onWindowFocusChanged(hasWindowFocus);
    }

    @Override
    public boolean isFocused() {
        return true;
    }
}
