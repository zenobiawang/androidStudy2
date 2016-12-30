package com.example.wanghui1.androidstudy.design.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;

import com.example.wanghui1.androidstudy.R;

/**
 * Created by wanghui on 2016/12/29.
 * 自定义View
 */

public class ViewDemo extends View {
    private float mTextSize;
    private String mText;
    private int mTextStartColor;
    private int mTextEndColor;
    private int mDefaultStartColor;
    private int mDefaultEndColor;

    public ViewDemo(Context context) {
        this(context, null);
    }

    public ViewDemo(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public ViewDemo(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mDefaultStartColor = context.getResources().getColor(android.R.color.white);
        mDefaultEndColor = context.getResources().getColor(android.R.color.black);

        TypedArray array = context.obtainStyledAttributes(attrs, R.styleable.ViewDemo);
        mTextSize = array.getDimension(R.styleable.ViewDemo_textSize, 32);
        mTextStartColor = array.getColor(R.styleable.ViewDemo_textStartColor, mDefaultStartColor);
        mTextEndColor = array.getColor(R.styleable.ViewDemo_textEndColor, mDefaultEndColor);
        mText = array.getString(R.styleable.ViewDemo_text);
        array.recycle();
    }
}
