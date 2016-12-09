package com.example.wanghui1.androidstudy.design.view;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by wanghui on 2016/12/7.
 * 自定义ViewGroup demo 平均分布的布局
 */
public class ViewGroupDemo extends ViewGroup {
    private static String TAG = "ViewGroupDemo";
    private int childWidth;
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
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int height = 0;
        int count = getChildCount();
        measureChildren(widthMeasureSpec, heightMeasureSpec);
        for (int i = 0; i < count; i ++){
            int childHeight = getChildAt(i).getMeasuredHeight();
            Log.d(TAG, "wh----height--" + childHeight);
            height = childHeight > height? childHeight : height;
        }
        setMeasuredDimension(resolveSize(MeasureSpec.getSize(widthMeasureSpec),
                widthMeasureSpec), resolveSize(height, heightMeasureSpec));
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        Log.d(TAG, "wh------sizeChanged---" + w + "--"+ h+ "--"+ oldw+ "--"+ oldh);
        int count = getChildCount();
        childWidth = w/count;
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        for (int i = 0; i < getChildCount(); i ++){
            View childView = getChildAt(i);
            Log.d(TAG, "wh------tb---" + childWidth * i + "--"+ t+ "--"+ childWidth * (i + 1)+ "--"+ b);
            childView.layout(childWidth * i, t, childWidth * (i + 1), b);
        }
    }
}
