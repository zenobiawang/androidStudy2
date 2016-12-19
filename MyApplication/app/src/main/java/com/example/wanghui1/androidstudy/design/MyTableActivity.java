package com.example.wanghui1.androidstudy.design;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.wanghui1.androidstudy.R;
import com.example.wanghui1.androidstudy.base.BaseActivity;

/**
 * Created by wanghui on 2016/12/15.
 */
public class MyTableActivity extends BaseActivity {
    private static String TAG = "MyTableActivity";
    private RecyclerView mRecycleView;

    @Override
    protected void init(Bundle savedInstanceState, View view) {
        mRecycleView = (RecyclerView) view.findViewById(R.id.rv_my_table);
        mRecycleView.setLayoutManager(new GridLayoutManager(this, 3));
        mRecycleView.setAdapter(new MyAdapter());
        mRecycleView.addItemDecoration(new MyItemDecoration(this));
    }

    @Override
    protected int getContentLayout() {
        return R.layout.activity_my_table;
    }

    private class MyItemDecoration extends RecyclerView.ItemDecoration{
        private final int[] ATTRS = new int[] { android.R.attr.listDivider };
        private Drawable mDivider;

        public MyItemDecoration(Context context)
        {
            final TypedArray a = context.obtainStyledAttributes(ATTRS);
            mDivider = a.getDrawable(0);
            a.recycle();
        }

        @Override
        public void onDraw(Canvas c, RecyclerView parent, RecyclerView.State state)
        {

            drawHorizontal(c, parent);
            drawVertical(c, parent);

        }

        private int getSpanCount(RecyclerView parent)
        {
            // 列数
            int spanCount = -1;
            RecyclerView.LayoutManager layoutManager = parent.getLayoutManager();
            if (layoutManager instanceof GridLayoutManager)
            {

                spanCount = ((GridLayoutManager) layoutManager).getSpanCount();
            } else if (layoutManager instanceof StaggeredGridLayoutManager)
            {
                spanCount = ((StaggeredGridLayoutManager) layoutManager)
                        .getSpanCount();
            }
            return spanCount;
        }

        public void drawHorizontal(Canvas c, RecyclerView parent)
        {
            int childCount = parent.getChildCount();
            for (int i = 0; i < childCount; i++)
            {
                final View child = parent.getChildAt(i);
                final RecyclerView.LayoutParams params = (RecyclerView.LayoutParams) child
                        .getLayoutParams();
                final int left = child.getLeft() - params.leftMargin;
                final int right = child.getRight() + params.rightMargin
                        + mDivider.getIntrinsicWidth();
                final int top = child.getBottom() + params.bottomMargin;
                final int bottom = top + mDivider.getIntrinsicHeight();
                mDivider.setBounds(left, top, right, bottom);
                mDivider.draw(c);
            }
        }

        public void drawVertical(Canvas c, RecyclerView parent)
        {
            final int childCount = parent.getChildCount();
            for (int i = 0; i < childCount; i++)
            {
                final View child = parent.getChildAt(i);

                final RecyclerView.LayoutParams params = (RecyclerView.LayoutParams) child
                        .getLayoutParams();
                final int top = child.getTop() - params.topMargin;
                final int bottom = child.getBottom() + params.bottomMargin;
                final int left = child.getRight() + params.rightMargin;
                final int right = left + mDivider.getIntrinsicWidth();

                mDivider.setBounds(left, top, right, bottom);
                mDivider.draw(c);
            }
        }

        private boolean isLastColum(RecyclerView parent, int pos, int spanCount,
                                    int childCount)
        {
            RecyclerView.LayoutManager layoutManager = parent.getLayoutManager();
            if (layoutManager instanceof GridLayoutManager)
            {
                if ((pos + 1) % spanCount == 0)// 如果是最后一列，则不需要绘制右边
                {
                    return true;
                }
            } else if (layoutManager instanceof StaggeredGridLayoutManager)
            {
                int orientation = ((StaggeredGridLayoutManager) layoutManager)
                        .getOrientation();
                if (orientation == StaggeredGridLayoutManager.VERTICAL)
                {
                    if ((pos + 1) % spanCount == 0)// 如果是最后一列，则不需要绘制右边
                    {
                        return true;
                    }
                } else
                {
                    childCount = childCount - childCount % spanCount;
                    if (pos >= childCount)// 如果是最后一列，则不需要绘制右边
                        return true;
                }
            }
            return false;
        }

        private boolean isLastRaw(RecyclerView parent, int pos, int spanCount,
                                  int childCount)
        {
            RecyclerView.LayoutManager layoutManager = parent.getLayoutManager();
            if (layoutManager instanceof GridLayoutManager)
            {
                childCount = childCount - childCount % spanCount;
                if (pos >= childCount)// 如果是最后一行，则不需要绘制底部
                    return true;
            } else if (layoutManager instanceof StaggeredGridLayoutManager)
            {
                int orientation = ((StaggeredGridLayoutManager) layoutManager)
                        .getOrientation();
                // StaggeredGridLayoutManager 且纵向滚动
                if (orientation == StaggeredGridLayoutManager.VERTICAL)
                {
                    childCount = childCount - childCount % spanCount;
                    // 如果是最后一行，则不需要绘制底部
                    if (pos >= childCount)
                        return true;
                } else
                // StaggeredGridLayoutManager 且横向滚动
                {
                    // 如果是最后一行，则不需要绘制底部
                    if ((pos + 1) % spanCount == 0)
                    {
                        return true;
                    }
                }
            }
            return false;
        }

        @Override
        public void getItemOffsets(Rect outRect, int itemPosition,
                                   RecyclerView parent)
        {
            Log.d(TAG, "wh------" + outRect.toString());
            int spanCount = getSpanCount(parent);
            int childCount = parent.getAdapter().getItemCount();
            if (isLastRaw(parent, itemPosition, spanCount, childCount))// 如果是最后一行，则不需要绘制底部
            {
                outRect.set(0, 0, mDivider.getIntrinsicWidth(), 0);
            } else if (isLastColum(parent, itemPosition, spanCount, childCount))// 如果是最后一列，则不需要绘制右边
            {
                outRect.set(0, 0, 0, mDivider.getIntrinsicHeight());
            } else
            {
                outRect.set(0, 0, mDivider.getIntrinsicWidth(),
                        mDivider.getIntrinsicHeight());
            }
        }

//        @Override
//        public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
//            super.getItemOffsets(outRect, view, parent, state);
//            Log.d(TAG, "wh------" + outRect.toString());
//            int spanCount = getSpanCount(parent);
//            int childCount = parent.getAdapter().getItemCount();
//            if (isLastRaw(parent, itemPosition, spanCount, childCount))// 如果是最后一行，则不需要绘制底部
//            {
//                outRect.set(0, 0, mDivider.getIntrinsicWidth(), 0);
//            } else if (isLastColum(parent, itemPosition, spanCount, childCount))// 如果是最后一列，则不需要绘制右边
//            {
//                outRect.set(0, 0, 0, mDivider.getIntrinsicHeight());
//            } else
//            {
//                outRect.set(0, 0, mDivider.getIntrinsicWidth(),
//                        mDivider.getIntrinsicHeight());
//            }
//        }
    }

    private class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder>{

        @Override
        public MyAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            return new MyViewHolder(new TextView(MyTableActivity.this));
        }

        @Override
        public void onBindViewHolder(MyViewHolder holder, int position) {
            Log.d(TAG, "wh-----" + holder.textView);
            holder.textView.setText(String.valueOf(position));
        }


        @Override
        public int getItemCount() {
            return 100;
        }

        public class MyViewHolder extends RecyclerView.ViewHolder{
            private TextView textView;
            public MyViewHolder(View itemView) {
                super(itemView);
                textView = (TextView) itemView;
                textView.setGravity(Gravity.CENTER);
                Log.d(TAG, "wh-----" + itemView);
            }
        }
    }
}
