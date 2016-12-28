package com.example.wanghui1.androidstudy.design.view;

import android.content.Context;
import android.support.v4.view.MotionEventCompat;
import android.support.v4.widget.ViewDragHelper;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;


/**
 * Created by wanghui on 2016/12/26.
 */

public class ViewDragHelperDemo extends LinearLayout{
    private static String TAG = "ViewDragHelperDemo";
    private final ViewDragHelper mDragHelper;

    public ViewDragHelperDemo(Context context) {
        this(context, null);
    }

    public ViewDragHelperDemo(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public ViewDragHelperDemo(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        mDragHelper = ViewDragHelper.create(this, 1f, new DragHelperCallback());
    }

    private class DragHelperCallback extends ViewDragHelper.Callback {

        @Override
        public boolean tryCaptureView(View child, int pointerId) {

            return true;
        }


        @Override
        public int clampViewPositionVertical(View child, int top, int dy) {
                final int topBound = getPaddingTop();
                final int bottomBound = getHeight() - child.getHeight();

                final int newTop = Math.min(Math.max(top, topBound), bottomBound);

                return newTop;
        }

        @Override
        public int clampViewPositionHorizontal(View child, int left, int dx) {
                final int leftBound = getPaddingLeft();
                final int rightBound = getWidth() - child.getWidth();

                final int newLeft = Math.min(Math.max(left, leftBound), rightBound);

                return newLeft;
        }

    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        final int action = MotionEventCompat.getActionMasked(ev);
        if (action == MotionEvent.ACTION_CANCEL || action == MotionEvent.ACTION_UP) {
            mDragHelper.cancel();
            return false;
        }
        return mDragHelper.shouldInterceptTouchEvent(ev);
    }

    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        mDragHelper.processTouchEvent(ev);
        return true;
    }
}
