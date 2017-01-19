package com.example.wanghui1.androidstudy.design.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;

import com.example.wanghui1.androidstudy.R;

/**
 * Created by wanghui on 2017/1/12.
 * 显示大图    src
 */

public class LargeImageView extends View {

    public LargeImageView(Context context) {
        this(context, null);
    }

    public LargeImageView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public LargeImageView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

//        TypedArray array = context.obtainStyledAttributes(attrs, R.styleable.LargeImageView);

    }
}
