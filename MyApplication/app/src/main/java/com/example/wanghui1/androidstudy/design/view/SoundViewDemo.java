package com.example.wanghui1.androidstudy.design.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;

import com.example.wanghui1.androidstudy.R;

/**
 * Created by wanghui on 2017/1/9.
 * 音量demo
 * 需要自定义属性：小方块的宽度，小方块直接的间隔，环绕总角度，默认方块颜色，当前达到音量颜色，中间图标，总半径
 */

public class SoundViewDemo extends View {
    /**
     *  <attr name="radius" format="integer"/>
     <attr name="blockHeight" format="dimension"/>
     <attr name="blockSpacing" format="dimension"/>
     <attr name="angle" format="integer"/>
     <attr name="defaultColor" format="color"/>
     <attr name="currentColor" format="color"/>
     <attr name="centerSrc" format="reference"/>
     * @param context
     */
    private int mRadius; //半径
    private float mBlockHeight;//小块的宽度
    private float mBlockSpacing;//小方块之间的间隔
    private int mAngle;//音量环绕角度
    private int mDefaultColor;//默认方块颜色
    private int mCurrentColor;//当前音量颜色
    private int mCenterSrc; //中间图标

    private Paint mPaint;
    public SoundViewDemo(Context context) {
        this(context, null);
    }

    public SoundViewDemo(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public SoundViewDemo(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        TypedArray array = context.obtainStyledAttributes(attrs, R.styleable.SoundViewDemo);
        mRadius = array.getInt(R.styleable.SoundViewDemo_radius, 50);
        mBlockHeight = array.getDimension(R.styleable.SoundViewDemo_blockHeight, 5);
        mBlockSpacing  = array.getDimension(R.styleable.SoundViewDemo_blockSpacing, 5);
        mAngle = array.getInt(R.styleable.SoundViewDemo_angle, 360);
        mDefaultColor = array.getColor(R.styleable.SoundViewDemo_defaultColor, getResources().getColor(android.R.color.darker_gray));
        mCurrentColor = array.getColor(R.styleable.SoundViewDemo_currentColor, getResources().getColor(android.R.color.black));
        mCenterSrc = array.getResourceId(R.styleable.SoundViewDemo_centerSrc, -1);
        array.recycle();

        mPaint = new Paint();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        drawBlock(canvas);
    }

    private void drawBlock(Canvas canvas) {
        Rect blockRect = new Rect();
//        canvas.drawArc();
    }
}
