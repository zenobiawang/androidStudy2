package com.example.wanghui1.androidstudy.design;

import android.os.Bundle;
import android.view.View;

import com.example.wanghui1.androidstudy.R;
import com.example.wanghui1.androidstudy.base.BaseActivity;
import com.example.wanghui1.androidstudy.resoucecode.ResourceCodeSplashActivity;

/**
 * Created by wanghui on 2016/11/25.
 * 自定义View
 */

public class DesignSplashActivity extends BaseActivity {
    @Override
    protected void init(Bundle savedInstanceState, View view) {
        initListener();
    }

    private void initListener() {
        findViewById(R.id.btn_text_input).setOnClickListener(view -> startActivity(this, TextInputLayoutTestActivity.class));
        findViewById(R.id.btn_view_group_demo).setOnClickListener(view -> startActivity(this, ViewDemoTestActivity.class));
    }

    @Override
    protected int getContentLayout() {
        return R.layout.activity_design_splash;
    }
}
