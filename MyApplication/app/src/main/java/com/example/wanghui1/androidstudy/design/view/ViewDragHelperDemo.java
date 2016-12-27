package com.example.wanghui1.androidstudy.design.view;

import android.content.Context;
import android.support.v4.view.MotionEventCompat;
import android.support.v4.widget.ViewDragHelper;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;

import com.example.wanghui1.androidstudy.R;

/**
 * Created by wanghui on 2016/12/26.
 */

public class ViewDragHelperDemo extends LinearLayout{
    private static String TAG = "ViewDragHelperDemo";
    private ViewDragHelper mDragHelper;
    private View mDragView1;

    public ViewDragHelperDemo(Context context) {
        this(context, null);
    }

    public ViewDragHelperDemo(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public ViewDragHelperDemo(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mDragView1 = findViewById(R.id.drag1);
        mDragHelper = ViewDragHelper.create(this, 1.0f, new ViewDragHelper.Callback() {
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

            @Override
            public void onViewPositionChanged(View changedView, int left, int top, int dx, int dy) {
                invalidate();
            }

            @Override
            public void onEdgeDragStarted(int edgeFlags, int pointerId) {
                mDragHelper.captureChildView(mDragView1, pointerId);
            }
        });
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        mDragHelper.processTouchEvent(event);
        return true;
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        final int action = MotionEventCompat.getActionMasked(ev);
        if (action == MotionEvent.ACTION_CANCEL || action == MotionEvent.ACTION_UP) {
            mDragHelper.cancel();
            return false;
        }
        return mDragHelper.shouldInterceptTouchEvent(ev);
    }


}
