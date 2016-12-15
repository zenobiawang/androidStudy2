package com.example.wanghui1.androidstudy.design;

import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.wanghui1.androidstudy.R;
import com.example.wanghui1.androidstudy.base.BaseActivity;

/**
 * Created by wanghui on 2016/12/15.
 */

public class MyTableActivity extends BaseActivity {
    private RecyclerView mRecycleView;

    @Override
    protected void init(Bundle savedInstanceState, View view) {
        mRecycleView = (RecyclerView) view.findViewById(R.id.rv_my_table);
    }

    @Override
    protected int getContentLayout() {
        return R.layout.activity_my_table;
    }
}
