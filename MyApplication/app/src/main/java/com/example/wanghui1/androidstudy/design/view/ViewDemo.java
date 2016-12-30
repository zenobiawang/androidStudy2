package com.example.wanghui1.androidstudy.design.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

import com.example.wanghui1.androidstudy.R;

/**
 * Created by wanghui on 2016/12/29.
 * 自定义View
 */

public class ViewDemo extends View {
    private static String TAG = "ViewDemo";
    private float mTextSize;
    private String mText;
    private int mTextStartColor;
    private int mTextEndColor;
    private int mDefaultStartColor;
    private int mDefaultEndColor;
    private Paint mPaint;
    private Rect mBound;

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
        mTextSize = array.getDimensionPixelSize(R.styleable.ViewDemo_textSize, 32);
        mTextStartColor = array.getColor(R.styleable.ViewDemo_textStartColor, mDefaultStartColor);
        mTextEndColor = array.getColor(R.styleable.ViewDemo_textEndColor, mDefaultEndColor);
        mText = array.getString(R.styleable.ViewDemo_text);
        array.recycle();

        mPaint = new Paint();
        mPaint.setTextSize(mTextSize);
        mBound = new Rect();
        mPaint.getTextBounds(mText, 0, mText.length(), mBound);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int widthSize = MeasureSpec.getSize(widthMeasureSpec);
        int widthMode = MeasureSpec.getMode(widthMeasureSpec);
        int heightSize = MeasureSpec.getSize(heightMeasureSpec);
        int heightMode = MeasureSpec.getSize(heightMeasureSpec);
        int measureWidth, measuredHeight;
        if (widthMode == MeasureSpec.EXACTLY){
            measureWidth = widthSize;
        }else {
//            mPaint.setTextSize(mTextSize);
//            mPaint.getTextBounds(mText, 0, mText.length(), mBound);
            measureWidth = mBound.width() + getPaddingLeft() + getPaddingRight();
        }

        if (heightMode == MeasureSpec.EXACTLY){
            measuredHeight = heightSize;
        }else {
            measuredHeight = mBound.height() + getPaddingBottom() + getPaddingTop();
        }

        setMeasuredDimension(measureWidth, measuredHeight);
        Log.d(TAG, "wh-----measureSize---" + measureWidth + "---" + measuredHeight);
//        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        Log.d(TAG, "wh------position---" + getTop() + "---" + getBottom());
        LinearGradient gradient = new LinearGradient(getLeft(), getTop(), mBound.width(), mBound.height(),
                mTextStartColor, mTextEndColor, Shader.TileMode.CLAMP);
        mPaint.setShader(gradient);
        canvas.drawText(mText, getWidth()/2 - mBound.width()/2, getHeight()/2 - mBound.height()/2, mPaint);
    }
}
