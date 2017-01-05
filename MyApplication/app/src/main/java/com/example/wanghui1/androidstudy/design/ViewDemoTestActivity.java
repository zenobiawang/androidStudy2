package com.example.wanghui1.androidstudy.design;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.wanghui1.androidstudy.R;
import com.example.wanghui1.androidstudy.base.BaseActivity;

/**
 * Created by wanghui on 2016/12/7.
 */

public class ViewDemoTestActivity extends BaseActivity {
    @Override
    protected void init(Bundle savedInstanceState, View view) {

    }

    @Override
    protected int getContentLayout() {
        Log.d("test", "wh-----test");
        return R.layout.activity_view_demo;
    }
}
