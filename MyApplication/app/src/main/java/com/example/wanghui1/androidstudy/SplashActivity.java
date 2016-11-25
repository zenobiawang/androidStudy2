package com.example.wanghui1.androidstudy;

import android.os.Bundle;
import android.view.View;

import com.example.wanghui1.androidstudy.base.BaseActivity;
import com.example.wanghui1.androidstudy.design.DesignSplashActivity;
import com.example.wanghui1.androidstudy.resoucecode.ResourceCodeSplashActivity;

/**
 * Created by wanghui on 2016/11/22.
 */

public class SplashActivity extends BaseActivity {
    @Override
    protected void init(Bundle savedInstanceState, View view) {
       initListener();
    }

    private void initListener() {
        findViewById(R.id.btn_source_code).setOnClickListener(view -> startActivity(this, ResourceCodeSplashActivity.class));
        findViewById(R.id.btn_design).setOnClickListener(view -> startActivity(this, DesignSplashActivity.class));

    }

    @Override
    protected int getContentLayout() {
        return R.layout.activity_splash;
    }
}
