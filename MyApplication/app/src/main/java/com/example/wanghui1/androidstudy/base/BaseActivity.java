package com.example.wanghui1.androidstudy.base;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.view.View;

/**
 * Created by wanghui on 2016/11/22.
 * 公共Activity
 */

public abstract class BaseActivity extends FragmentActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        View view = View.inflate(this, getContentLayout(), null);
        setContentView(view);
        init(savedInstanceState, view);
    }

    public void startActivity(Context context,Class<?> targetActivity){
        Intent intent = new Intent(context, targetActivity);
        context.startActivity(intent);
    }

    protected abstract void init(Bundle savedInstanceState, View view);

    protected abstract int getContentLayout();
}
