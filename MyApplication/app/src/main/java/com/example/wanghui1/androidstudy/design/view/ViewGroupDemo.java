package com.example.wanghui1.androidstudy.design.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;

import com.example.wanghui1.androidstudy.R;

/**
 * Created by wanghui on 2016/12/7.
 * 自定义ViewGroup demo 平均分布的布局
 */
public class ViewGroupDemo extends ViewGroup {
    private static String TAG = "ViewGroupDemo";
    private int childWidth;
    private int height;
    public ViewGroupDemo(Context context) {
        this(context, null);
    }

    public ViewGroupDemo(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public ViewGroupDemo(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        TypedArray array = context.obtainStyledAttributes(attrs, R.styleable.ViewGroupDemo);
        height = array.getInt(R.styleable.ViewGroupDemo_count, 0);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int height = 0;
        int count = getChildCount();
        measureChildren(widthMeasureSpec, heightMeasureSpec);
        for (int i = 0; i < count; i ++){
            int childHeight = getChildAt(i).getMeasuredHeight();
            Log.d(TAG, "wh----height--" + childHeight);
            height = childHeight > height? childHeight : height;
        }
//        setMeasuredDimension(resolveSize(MeasureSpec.getSize(widthMeasureSpec),
//                widthMeasureSpec), resolveSize(height, heightMeasureSpec));
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
            childView.layout(childWidth * i, t, childWidth * (i + 1), t + height);
        }
    }
}
