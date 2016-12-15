package com.example.wanghui1.androidstudy.design;

import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
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
    }

    @Override
    protected int getContentLayout() {
        return R.layout.activity_my_table;
    }

    private class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder>{

        @Override
        public MyAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            return new MyViewHolder(new TextView(MyTableActivity.this));
        }

        @Override
        public void onBindViewHolder(MyViewHolder holder, int position) {
            Log.d(TAG, "wh-----" + holder.textView);
            holder.textView.setText(position);
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
                Log.d(TAG, "wh-----" + itemView);
            }
        }
    }
}
