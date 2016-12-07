package com.example.wanghui1.androidstudy.design.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup;

/**
 * Created by wanghui on 2016/12/7.
 * 自定义ViewGroup demo
 */

public class ViewGroupDemo extends ViewGroup {
    public ViewGroupDemo(Context context) {
        super(context);
    }

    public ViewGroupDemo(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public ViewGroupDemo(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {

    }
}
